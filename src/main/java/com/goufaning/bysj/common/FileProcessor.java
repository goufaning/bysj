package com.goufaning.bysj.common;

import com.google.common.base.Strings;
import com.goufaning.bysj.mapmap.HashMapmap;
import com.goufaning.bysj.mapmap.Mapmap;
import com.goufaning.bysj.pojo.Literature;
import com.goufaning.bysj.pojo.Word;
import com.goufaning.bysj.utils.DataUtil;
import com.goufaning.bysj.utils.ExcludeStopWordUtil;
import com.goufaning.bysj.utils.FileUtil;
import com.goufaning.bysj.utils.NIpirUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileProcessor {

    @Value("${file.path}")
    public static String filePath;

    public Map<String, List<Literature>> userId2Literature = new HashMap<>();

    private static int docId = 1;

    private static int wordIndex = 1;

    private static FileProcessor instance = new FileProcessor();

    private static Map<String, Integer> word2index = new HashMap<>();

    private static Mapmap<Integer, String, Integer> docid2word2freq = new HashMapmap<>();

    private static Map<Integer, String> docId2docName = new HashMap<>();

    private FileProcessor(){};

    public static FileProcessor getInstance() {
        return instance;
    }

    public void setFilePath(String path) {
        filePath = path;
    }

    public String getFilePath() {
        return filePath;
    }

    /**
     * 添加用户文献
     * @param literature
     */
    public void addLiterature(Literature literature) {
        String userId = literature.getUserId();
        List<Literature> literatureList = getLiteratureList(userId);
        if (null == literatureList) {
            literatureList = new LinkedList<>();
        }
        literatureList.add(literature);
        userId2Literature.put(userId, literatureList);
    }

    public void removeAllLiterature(String userId) {
        if (null != getLiteratureList(userId)) {
            for (Literature l : getLiteratureList(userId)) {
                String name = l.getDocName();
                String path = filePath + File.separator + name;
                FileUtil.deleteFile(path);
            }
            userId2Literature.remove(userId);
        }
    }

    public void removeLiterature(String userId, String docName) {
        List<Literature> literatureList = getLiteratureList(userId);
        if (null == literatureList || literatureList.size() == 0) {
            return;
        }
        for (Literature literature : literatureList) {
            if (docName.equals(literature.getDocName())) {
                // 删除后不继续循环。不会报错
                literatureList.remove(literature);
                return;
            }
        }
    }

    /**
     * 获取用户文章列表
     * @param userID
     * @return
     */
    public List<Literature> getLiteratureList(String userID) {
        if (null != userId2Literature.get(userID)) {
            return userId2Literature.get(userID);
        }
        return  null;
    }

    public Literature getLiterature(String userId, String literatureName) {
        List<Literature> literatureList = getLiteratureList(userId);
        if (null == literatureList || literatureList.size() == 0) {
            return null;
        }
        for (Literature literature : literatureList) {
            if (literatureName.equals(literature.getDocName())) {
                return literature;
            }
        }
        return null;
    }

    public static String textPreprocess(String docName, String str) throws UnsupportedEncodingException {
        docId2docName.put(docId, docName);
        String fenciResult = NIpirUtil.fenci(str.trim());
        System.out.println(fenciResult);
        Map<String, Integer> result  = DataUtil.statisticalFrequency(fenciResult);
        List<Word> word = new LinkedList<Word>();
        for (String key : result.keySet()) {
            if (Strings.isNullOrEmpty(key)|| ExcludeStopWordUtil.isStopWord(key)) {
                continue;
            }
            int index = wordIndex;
            if (word2index.containsKey(key)) {
                index = word2index.get(key);
            } else {
                word2index.put(key, index);
                wordIndex++;
            }
            int freq = result.get(key);
            word.add(new Word(key, freq));
            docid2word2freq.put(docId, key, freq);
        }
        docId++;
        JSONArray array = new JSONArray(word);
        return array.toString();
    }
}
