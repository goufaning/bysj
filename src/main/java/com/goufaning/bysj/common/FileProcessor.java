package com.goufaning.bysj.common;

import com.google.common.base.Strings;
import com.goufaning.bysj.mapmap.HashMapmap;
import com.goufaning.bysj.mapmap.Mapmap;
import com.goufaning.bysj.pojo.Literature;
import com.goufaning.bysj.pojo.Word;
import com.goufaning.bysj.utils.DataUtil;
import com.goufaning.bysj.utils.ExcludeStopWordUtil;
import com.goufaning.bysj.utils.NIpirUtil;
import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileProcessor {

    private static final String text = " title： 外源性神经生长因子对脑缺血再灌注大鼠血脑屏障通透性及对脑神经保护和修复研究\n" +
            " abstract： 大量的国内外实验研究证实神经生长因子对神经细胞具有营养、修复、再生的功能，对急性神经损伤和功能修复有重要意义。然而，由于外源性神经生长因子是一大分子物质，在机体健康状态下，肌注或静滴给药无法穿透血脑屏障，在病理状态下是否能穿透血脑屏障呢？穿透量有多大，持续时间多长，在脑内的分布是怎样的，这些问题一直困扰临床医生，使医生在用药和临床效果评价方面缺乏实验依据和理论基础，本研究将在国内外研究基础上系统地对已在临床上应用的外源性神经生长因子在中枢疾病状态下穿透血脑屏障、在损伤脑组织的分布及对神经生长相关蛋白GAP43和神经细胞信号转导P140TrkA/P75NTR比值的影响，为脑神经细胞修复和临床用药提供理论和实验依据。\n" +
            " keyword： 外源性神经生长因子;血脑屏障;脑神经保护；脑神经修复\n" +
            " text： 神经生长因子家族主要包括：神经生长因子（nervegrowthfactor，NGF）、脑源性神经生长因子（BDNF）、神经营养素3－6（NT3-NT6）和胶质细胞源性神经营养因子（GDNF），其中神经生长因子是1953年由Levi-MontalciniHamburg和Cohen在小鼠S-180肉瘤细胞内发现的，是目前唯一被阐明结构的一种神经生长调节因子，其对神经系统具有重要的神经元营养和促神经突起生长的生物效应，表现在：(1)在神经系统的发育期具有促进神经元的分化，诱导神经元的定向生长，影响神经纤维支配效应细胞的密度，刺激胞体和树突的发育，控制神经元存活数量等作用；(2)在神经系统发育成熟期不仅具有维持NGF依赖性交感神经元的存活的功能，而且具有维持感觉神经元和中枢神经元群的功能，促进成熟神经元轴索分支和其他细胞的相互联络作用；(3)神经元的损伤修复期在离体、培养动物试验和临床观察中，NGF能促进神经纤维的定向生长，诱导轴突、树突的发育，促进神经元的有丝分裂、分化、修复，促进雪旺氏细胞及胶质细胞生长．使髓鞘修复，且能保护受损神经元免遭继续损害，减少神经细胞的死亡，支持神经元的存活，因而它是神经系统最重要的生物活性分子之一。由于对神经系统疾病目前尚缺乏有效的防治手段，因此，NGF的出现为人们治疗中枢和外周神经系统损伤带来了希望，从而成为研究的热点。NGF是由三种不同类型的蛋白质组成的复合物，分子量为140000左右，我们通常称为7SNGF,其三种蛋白质分别为一个β亚单位和两个α亚单位以及两个γ亚单位以非共价键结合。其组合比例为α2βγ2。小鼠、人、大鼠的NGF基因现已成功分离。小鼠基因组位于第3号染色体。从小鼠颌下腺中提取的神经生长因子，沉降系数2.5S，分子量13.5KD，其编码基因全长45Kb、有5个外显子和6个内含子。编码成熟NGF的序列在第5外显子的3’端区域。人NGF基因组位于第1号染色体短臂，其大小、结构与小鼠的相似，而且它们都是单拷贝基因。该基因在小鼠体内至少有四种转录产物。主要的翻译产物是3.4KD和2.7KDa的NGF前体分子。它们在酶解后形成含118个氨基酸残基的成熟NGF，雄激素、甲状腺激素可在转录水平影响NGF基因表达。小鼠与人NGF之间氨基酸序列同源率高达89％。其中与功能密切相关的一级结构还包括：1、构成NGF肽链内三对二硫键的6个半胱氨酸残基位置相同。2、水解前体分子时酶识别的双碱性氨基酸残基位置相同。3、与NGF活性有关的组氨酸、色氨酸和赖氨酸残基定位基本一致。4．糖基化位点，即天冬酰胺残基的位置都一样。这说明NGF之间具有大量结构特征的保守性和功能的高度相似性。在生理情况下，NGF在脑内的含量从高到低依次为海马、大脑皮质、嗅球、基底节、前脑、小脑和纹状体，其受体有两种，分别是分子量140kD的高亲合力受体TrkA和分子量75kD的低亲合力受体P75NTR，NGF与NGFR的结合引起受体的二聚化，高亲合力受体的形成除NGF与TrkA的结合外，还需P75NTR的作用，P75NTR与NGF的结合可提高细胞表面NGF的有效浓度，在两种受体均表达的细胞表面可使NGF的亲合力提高25倍。TrkA的信号转导也受P75NTR的影响，在P75NTR存在的条件下，可以促进TrkA的自身磷酸化、结构可以发生变化，导致与配基结合能力和信号转导功能的改变。NGF的信号转导一是TrkA介导的信号通路，它通过自身的磷酸化和Ras蛋白途径引起一系列的蛋白激酶活化、活化诱导多种基因的表达，主要作用是维持神经和免疫细胞的存活，促进神经元的分化、其中Ras蛋白的活化是整条通路的关键；另一条是P75NTR介导的信号通路，它通过未知信号蛋白活化JNK蛋白，主要功能是诱导细胞的调亡（图1）。NGF对神经细胞的作用究竟是促进细胞分化还是诱导细胞调亡主要是看P140TrkA与P75NTR的比例。比值越大，则促进神经元的有丝分裂、分化、修复，促进雪旺氏细胞及胶质细胞生长．使髓鞘修复，且能保护受损神经元免遭继续损害，减少神经细胞的死亡，支持神经元的存活，比值越小，则细胞主要处于调亡状态。但是其具体比例现在还不是很清楚，且尚未见在脑缺血时其比例时态变化的文献，如能知道其比例对NGF的临床应用将有巨大意义。\u0001\u0015脑缺血再灌注是由于栓子或局部血栓造成主要脑动脉阻塞，使脑血流暂时或持续性减少所致，受损组织的再灌注引发炎症、细胞兴奋性毒性、NO产生、自由基损伤、细胞凋亡等脑缺血级联反应，是临床常见的一种疾病，发病率约为250-400/10万，病死率约为30%，是死亡的第三位原因，也是成年人致残的主要因素之一。有文献报道：不同原因的脑损伤均可引起NGF的表达增加，闭塞两侧颈总动脉2min后再灌注，造成前脑短暂性缺血，2h后齿状回NGFmRNA表达即可增加，4h表达水平最高，24h降至对照组水平。而现有研究表明：NGF对脑缺血具有确切的保护和治疗作用，其机制可能是：（1）提高自由基清除剂的活性。脑缺血损伤时，正常神经元的细胞膜受到破坏，脑内氧自由基和脂质过氧化物明显增多。有实验显示，NGF能增加过氧化氢酶、SOD、谷胱甘肽过氧化物酶等自由基清除剂的活性。（2）拮抗兴奋性氨基酸的神经毒性。（3）稳定细胞内Ca2＋浓度。自由基与兴奋性氨基酸损伤均可引起Ca2＋超载。Ca2＋超载预示着细胞破坏和死亡。NGF稳定细胞内Ca2＋浓度的机制在于诱导钙结合蛋白的表达、影响通道与排出系统的表达与活化，从而稳定细胞内Ca2＋浓度（4）促进神经生长相关蛋白GAP43及突触素的表达，GAP43是80年代初发现的与神经发育,轴突再生,突触重建密切相关的一种快速转运胞膜磷酸蛋白,被认为是神经元发育和再生的一个内在决定因子，F                                                                                                                             主要影响发育和再生轴突的生长能力，而突触素则认为是突触重建的重要标志，NGF促进它们的表达，对促进脑缺血后的神经再生有着重要意义。但是，脑缺血损害后引起NGF表达增加的时间很短，表达水平也很有限，很难对受损神经元起到全面而持久的保护作用，而且，它的治疗应用还受到血脑屏障的限制。血脑屏障（blood-brainbarrier,BBB）是指血液-脑组织和血液-脑脊液间的屏障功能。BBB曾被误认为是一层简单的膜,但实际上它是由腔形胞质、胞液、内皮细胞蛋白膜所构成。包括:(1)血液-脑组织,(2)血液-脑脊液,(3)脑脊液-脑组织三者各自之间的屏障功能,至今对脑脊液-脑组织屏障功能的认识尚不够全面。BBB是一个保护性装置,其屏障功能的存在首先利于保护大脑皮层的功能活动不因血液成分的改变而改变,以利于脑细胞内环境的相对稳定。一旦受到有害因素的损伤,这一屏障即可被破坏，脑损伤后血-脑钠离子交换增加,BBB开放,通透性增加,导致脑组织水肿。严重颅脑损伤可有血浆蛋白、大分子物质渗入脑组织内。国内外研究中对健康机体的BBB通透性研究较多，但对病理状态下BBB的通透性研究则较少，特别是对病理状态下大分子药物通透性的研究较少。现在实验室研究用的外源性神经生长因子为分子量13.5KD的大分子物质,尽管在药代实验中有约注射剂量的6%能通过血脑屏障,但通常的理论认为血脑屏障仅能通过1KD以下的小分子物质,在疾病状态下外源性神经生长因子透过血脑屏障的量有增加吗,透过的量有多大,足以产生药理效应吗?是否与病程时相有关系?纵观国内外关于神经生长因子的研究，发现有以下几点值得进一步探讨：目前关于外源性神经生长因子通透血脑屏障的报道，有少量关于7S神经生长因子的研究，然而其沉降系数远远大于目前已在临床应用的2.5S神经生长因子（小鼠颌下腺中提取纯化的神经生长因子，沉降系数2.5S，分子量13.5KD），并且其纯度和活性都未规范，因此各个实验室所得的研究结果不一致。无法有效指导已在临床应用神经生长因子产品的临床科研和治疗策略制定，造成临床和基础研究相脱离，浪费了大量人力物力财力。因而集中研究已在临床使用，已被国家药监局批准和标定的2.5S神经生长因子就显的非常必要和必需。关于外源性神经生长因子进入脑内后是否对改善损伤脑细胞的微环境减少脑神经元死亡，对受损后是否能促进损伤修复和神经元再生都有少量研究，但是这些报道不系统，机制并未完全阐述清楚，且多为脑室注射给药途径，结果还不一致，使临床医生在用药的时候感到迷茫。本研究将用2.5S神经生长因子，以脑缺血再灌注为模型，研究神经生长因子通过血脑屏障量、以及对神经生长相关蛋白GAP43、突触素的影响，对兴奋性氨基酸的影响、对神经元内钙超载的影响、对自由基影响、对神经细胞凋亡影响及对P140TrkA与P75NTR比值的影响，系统地探讨外源性神经生长因子通过血脑屏障的量，对损伤脑神经细胞的保护和修复作用，考察其与病程时相和剂量的关系。以期为临床用药，制定脑损伤治疗策略提供参考，使基础研究服务于临床应用。外源性神经生长因子对缺血再灌注大鼠血脑屏障通过率研究，通过该项研究，探讨脑缺血状态下外源性神经神经生长因子血脑屏障通过率及通过率与病程的关系，为临床运用外源性神经生长因子的剂量及疗程提供参考依据。外源性神经生长因子在脑组织的分布研究，探讨脑损伤后外源性神经生长因子是否在损伤区有特异性的聚集，为临床治疗方案提供实验依据。外源性神经生长因子对脑细胞损伤的保护因素的影响，如对神经生长相关蛋白GAP43、突触素、兴奋性氨基酸、神经元内钙超载、自由基、神经细胞凋亡大经细胞凋亡酸的影响；先再灌注大鼠血脑屏障通透性研究。先提供理论                                                                                                影响。为临床治疗提供理论依据。观察NGF对P140TrkA/P75NTR比值的影响：复制大鼠脑缺血再灌注模型，模型分成对照组，NGF治疗组，给药7天、14天、21天处死取出脑组织，分离海马，采用免疫共沉淀和放射显影的方法观察P140TrkA/P75NTR比值的时态变化。探讨P140TrkA/P75NTR比值对大鼠脑缺血再灌注损伤的机制。3、拟采取的研究方案及可行性分析。外源性神经生长因子对缺血再灌注大鼠血脑屏障通过率研究。采用Nagasawa’s法加以改良复制大鼠脑缺血再灌注模型，将模型分成对照组和NGF大中小三个剂量治疗组，分别于再灌注后12小时、3天、7天、14天、21天处死，应用美国CHEMICAL的NGF试剂盒检测脑内NGF含量，考察不同剂量的NGF在不同时间通过血脑屏障的量。外源性神经生长因子在脑组织的分布研究　复制大鼠脑缺血再灌注模型，将模型分成对照组，NGF治疗组，治疗组采用上述实验中NGF含量最高的时间作为实验终止时间，取出脑组织，用免疫组化方法检测脑组织不同区域的NGF含量。以考察脑缺血时外源性NGF在脑组织中的分布。外源性神经生长因子对脑细胞损伤的保护因素的影响；神经生长标记分子—神经生长相关蛋白GAP43、突触素的影响：复制大鼠脑缺血再灌注模型，将模型分成对照组，NGF治疗组，用免疫组化方法检测7天、14天、21天脑缺血半影区GAP43、突触素的含量变化对兴奋性氨基酸的影响：复制大鼠脑缺血再灌注模型，将模型分成对照组，NGF治疗组，用高效液相（HPLC）方法检测7天、14天、21天脑组织中兴奋性氨基酸谷氨酸、天门冬氨酸的变化。神经元内钙超载影响：复制大鼠脑缺血再灌注模型，将模型分成对照组，NGF治疗组，在给药7天、14天、21天检测半影区脑神经元钙含量，并用膜片钳技术检测半影区脑神经元细胞膜钙通道。对脑神经元细胞凋亡的影响：复制大鼠脑缺血再灌注模型，模型分成对照组，NGF治疗组，给药7天、14天、21天处死取出脑组织，石蜡包埋,冠状切片,层厚5μm。TUNEL染色观察伤侧大脑半球凋亡细胞。对P140TrkA/P75NTR比值的影响：复制大鼠脑缺血再灌注模型，模型分成对照组，NGF治疗组，给药7天、14天、21天处死取出脑组织，分离海马，采用免疫共沉淀和放射显影的方法观察比值变化。4、本项目的特色与创新之处。用2.5S神经生长因子进行研究，研究结果对临床更具有参考价值；既往的研究通常用实验室生产的产品，神经生长因子的纯度、活性没有统一标准，实验结果存在差异，2.5S神经生长因子（已用于临床）的纯度和活性经国家规范和标定，实验结果更具推广意义。在同一实验条件下，对2.5S神经生长因子的通透性、通透时相、脑组织分布、脑神经细胞修复再生及再生环境进行研究，可排除实验条件外的因素干扰，结果更具参考价值。\n";

    /** 临时用 */
    public static String filePath = "C:\\Users\\10319\\Desktop\\2395.txt";

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

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(textPreprocess("", text));
    }
}
