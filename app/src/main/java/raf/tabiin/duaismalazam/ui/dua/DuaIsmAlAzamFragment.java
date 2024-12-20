package raf.tabiin.duaismalazam.ui.dua;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import raf.tabiin.duaismalazam.adapters.DrawerDuaAdapter;
import raf.tabiin.duaismalazam.adapters.DuaAdapter;
import raf.tabiin.duaismalazam.databinding.FragmentDuaIsmAlAzamBinding;
import raf.tabiin.duaismalazam.domain.models.DrawerDuaContent;
import raf.tabiin.duaismalazam.domain.models.DuaItem;
import raf.tabiin.duaismalazam.util.MyDrawerLayout;

public class DuaIsmAlAzamFragment extends Fragment {

    FragmentDuaIsmAlAzamBinding b;
    private String[] arabicDua, transcriptDua, translateDua, drawerContentList;
    private List<DuaItem> duaItemArrayList = new ArrayList<>();
    private List<DrawerDuaContent> duaDrawer = new ArrayList<>();
    private DuaAdapter duaAdapter;
    private DrawerDuaAdapter drawerDuaAdapter;
    private MyDrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentDuaIsmAlAzamBinding.inflate(getLayoutInflater());

        // Dua_Ism_Al_Azam

        // в пдф-файле в поиске ввести:
        // СОБРАНИЕ ДУ'А, В КОТОРЫЕ ВХОДИТ ВЕЛИЧАЙШЕЕ ИМЯ АЛЛАХА (АЛ-'ИСМ АЛ-'А'ЗАМ)

        arabicDua = new String[] {
                "مجموعة من الدعاء متضمنة اسم الله الأعظم",
                "يَا بَدِيعُ السَّمَوَاتِ يَا حَيُّ يَا قَيُّومُ إِنِّي أَسْأَلُك \n",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنَّ لَكَ الْحَمْدَ لَا إِلَهَ إِلَّا أَنْتَ الْمَنَّانُ، بَدِيعُ السَّمَوَاتِ وَالْأَرْضِ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ يَا حَيُّ يَا قَيُّومُ \n",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنَّ لَكَ الْحَمْدَ لَا إِلَهَ إِلَّا أَنْتَ الحَنَّانُ المَنَّانُ يَا بَدِيعَ السَّمَوَاتِ وَالْأَرْضِ يَا ذَا الْجَلَالِ وَالإِكْرَامِ أَسْأَلُكَ الْجَنَّةَ وَأَعُوذُ بِكَ مِنَ النَّارِ \n",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ بِلَا إِلَهَ إِلَّا أَنْتَ رَبُّ السَّمَوَاتِ السَّبْعِ وَرَبُّ الْعَرْشِ الكَرِيمِ وَأَسْأَلُكَ بِلَا إِلَهَ إِلَّا أَنْتَ رَبُّ السَّمَوَاتِ السَّبْعِ وَالْأَرْضِ وَمَا فِيهِنَّ إِنَّكَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ \n",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ أَنِّي أَشْهَدُ أَنَّكَ أَنْتَ اللَّهُ لَا إِلَهَ إِلَّا أَنْتَ الْأَحَدُ الصَّمَدُ الَّذِي لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُنْ لَهُ كُفُوا أَحَدٌ \n",
                "يَا رَبِّ يَا رَبِّ يَا رَبِّ يَا رَبِّ \n",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنَ الْخَيْرِ كُلِّهِ مَا عَلِمْتُ مِنْهُ وَمَا لَمْ أَعْلَمْ وَبِاسْمِكَ الْعَظِيمِ الَّذِي إِذَا دُعِيتَ بِهِ أَجَبْتَ وَإِذَا سُئِلْتَ بِهِ أَعْطَيْتَ \n",
                "لَا إِلَهَ إِلَّا اللَّهُ وَاللَّهُ أَكْبَرُ لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ لَا إِلَهَ إِلَّا اللَّهُ وَلَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ \n",
                "\nاللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنَّ لَكَ الْحَمْدَ لَا إِلَهَ إِلَّا أَنْتَ الحَنَّانُ الْمَنَّانُ يَا حَنَّانُ يَا مَنَّانُ. يَا بَدِيعَ السَّمَوَاتِ وَالْأَرْضِ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ",
                "يَا حَيُّ يَا قَيُّومُ لَا إِلَهَ إِلَّا أَنتَ سُبْحَانَكَ إِنِّي كُنتُ مِنَ الظَّالِمِينَ. اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنِّي أَشْهَدُ أَنَّكَ أَنتَ اللَّهُ لَا إِلَهَ إِلَّا أَنْتَ الْأَحَدُ الصَّمَدُ الَّذِي لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ \n",
                "الم اللَّهُ لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ \n" +
                        "\n" +
                        "وَإِلَهُكُمْ إِلَهُ وَاحِدٌ لَّا إِلَهَ إِلَّا هُوَ الرَّحْمَنُ الرَّحِيمُ \n" +
                        "\n" +
                        "يَا ذَا الْجَلَالِ وَالْإِكْرَامِ يَا أَرْحَمَ الرَّاحِمِينَ \n",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنَّكَ أَنْتَ اللَّهُ لَا إِلَهَ إِلَّا أَنْتَ الْوَاحِدُ الْفَرْدُ الصَّمَدُ الَّذِي لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ \n",
                "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ لَا إِلَهَ إِلَّا اللَّهُ وَلَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ الْعَلِيِّ الْعَظِيمِ . أَسْأَلُكَ بِاسْمِكَ الأَعَزُّ الْأَجَلُ الْأَكْرَمُ، رَبِّ رَبِّ رَبِّ يَا رَبِّ لَا إِلَهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ \n",
                "الْحَمْدُ اللهِ وَسُبْحَانَ اللَّهِ وَالْحَمْدُ للهِ وَلَا إِلَهَ إِلَّا اللهُ وَاللَّهُ أَكْبَرُ وَلَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ الْعَلِيِّ الْعَظِيمِ \n",
                "\n اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنِّي أَشْهَدُ أَنَّكَ لَا إِلَهَ إِلَّا أَنْتَ الْأَحَدُ الصَّمَدُ الَّذِي لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ",
                "\n يَا ذَا الْجَلَالِ وَالْإِكْرَام",
                "\n يَا أَرْحَمَ الرَّاحِمِينَ",
                "\n لَا إِلَهَ إِلَّا أَنتَ سُبْحَانَكَ إِنِّي كُنتُ مِنَ الظَّالِمِينَ",
                "\n اللَّهُمَّ، لَا إِلَهَ إِلَّا اللَّهُ أَنْتَ الْمَنَّانُ يَا بَدِيعَ السَّمَوَاتِ وَالْأَرْضِ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ",
                "\n اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنَّ لَكَ الْحَمْدَ لَا إِلَهَ إِلَّا أَنْتَ الْمُمَنَّانُ يَا بَدِيعَ السَّمَوَاتِ وَالْأَرْضِ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ",
                "\n اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنَّ لَكَ الْحَمْدَ لَا إِلَهَ إِلَّا أَنْتَ الْمَنَّانُ يَا حَنَّانُ يَا مَنَّانُ يَا بَدِيعَ السَّمَوَاتِ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ يَا حَيُّ يَا قَيُّومُ وَصَلَّى اللَّهُ عَلَى مُحَمَّدٍ وَعَلَى آلِ مُحَمَّدٍ وَاقْضِ حَاجَتِي بِرَحْمَتِكَ يَا أَرْحَمَ الرَّاحِمِينَ",
                "\n اللَّهُمَّ إِنِّي أَسْأَلُكَ بِاسْمِكَ الْأَعْظَمِ",
                "\n اللَّهُمَّ إِنِّي أَسْأَلُكَ بِاسْمِكَ الطَّاهِرِ الطَّيِّبِ الْمُبَارَكِ الْأَحَبِّ إِلَيْكَ الَّذِي إِذَا دُعِيتَ بِهِ أَجَبْتَ وَإِذَا سُئِلْتَ بِهِ أَعْطَيْتَ وَإِذَا اسْتَرْحِمتَ بِهِ رَحِمْتَ وَإِذَا اسْتَفْرِجْتَ بِهِ فَرَّجْتَ",
                "\n اللَّهُم إِنِّي أَدْعُوكَ اللَّهَ وَأَدْعُوكَ الرَّحْمَنَ وَأَدْعُوكَ الْبَرَّ الرَّحِيمَ وَأَدْعُوكَ بِأَسْمَاءِكَ الْحُسْنَى مَا عَلِمْتُ مِنْهَا وَمَا لَمْ أَعْلَمْ أَنْ تَغْفِرَ لِي وَتَرْحَمْنِي"

        };

        transcriptDua = new String[] {

                "СОБРАНИЕ ДУ'А, В КОТОРЫЕ ВХОДИТ ВЕЛИЧАЙШЕЕ ИМЯ АЛЛАХА (АЛ-'ИСМ АЛ-'А'ЗАМ)",
                "Йа бадй'у-с-самавати йа хаййу йа каййуму 'инни 'ас'алука... \n",
                "Аллахумма инни ас алюка би анна лякаль хамд, ля иляха илля Анталь Маннан, Бади'ус-Самавати уаль ард, йа Заль джаляли уаль икрам, йа Хаййу йа Каййум \n \n ",
                "Аллахумма инни ас алюка би анна лякаль хамд, ля иляха илля Анталь Ханнануль Маннан, йа Бади'ус-Самавати уаль ард, йа Заль джаляли уаль икрам ас алюкаль джанната уа а'узу бика минан-нар \n \n",
                "Аллахумма инни ас алюка би ля иляха илля Анта, Раббус-самаватис-саб'и уа Раббуль 'аршиль кярим, уа ас алюка би ля иляха илля Анта Раббус-самаватис-саб'и уаль арды уа маа фиихинна иннаКя 'аля кулли шай ин Кадир \n \n",
                "Аллахумма инни  ас алюка анни ашхаду аннаКя Анта Ллах. Ля иляха илля Анталь Ахадус-Самад. Аллязи лям йалид уа лям йуулид, уа лям йакуль-ляху куфу ван ахад \n \n",
                "Йа Рабби, Йа Рабби, Йа Рабби, Йа Рабби \n \n",
                "Аллахумма инни ас алюка миналь хайри куллихи маа 'алимту минху уа маа лям а'лям уа би исмикяль 'Азыми Ллязи иза ду'ыта бихи аджабта уа иза суильта бихи а'тайта \n \n",
                "Ля иляха илля Ллаху уаЛлаху Акьбар, ля иляха илля Ллаху уахдаХу ля шарика лях, ляхуль мульк, уа ляхуль хамд, уа Хува 'аля кулли шай ин кадиир. Ля иляха илля Ллаху уа ля хауля уа ля куввата илля биЛлях \n \n",
                "Аллахумма инни ас алюка би анна лякяль хамд. Ля иляха илля Анталь Ханнануль Маннан. Йа Ханнан. Йа Маннан. Йа Бади'ас-самауати уаль ард. Йа Заль джаляли уаль икрам",
                "Йа Хаййю йа Каййуму ля иляха илля Анта, субханаКя инни кунтк миназ-залимин. Аллахумма инни ас алюка би анни ашхаду аннаКя Анта Ллах. Ля иляха илля Анталь Ахадус-Самад. Аллязи лям йалид уа лям йуулид, уа лям йакуль-ляху куфу ван ахад \n \n",
                "Алиф Лям Мим. Аллаху ля иляха илля Хуваль Хаййуль Каййум. \n Уа иляхукум иляху Уахид. Ля иляха илля Хувар-Рахманур-Рахим \n Йа заль джаляли уаль икрами йа Архамар-Рахимин",
                "Аллахумма инни ас алюка би аннаКя анта Ллах. Ля иляха илля анталь Уахидуль фардус-Самад. Аллязи лям йалид уа лям йуулид, уа лям йакуль-ляху куфу ван ахад \n \n",
                "Ля иляха илля Ллаху уахдаху ля шарикя лях, ляхуль мульк, уа ляхуль хамд, уа Хува 'аля кулли шай ин кадир. Ля иляха илля Ллах, уа ля хауля уа ля куввата илля биЛляхиль 'Алиййиль 'Азым. Ас алюкя бисмиКяль А'Аззуль Аджяллюль Акьрам. Рабби! Рабби! Рабби! Йа Рабби! Ля иляха илля Ллаху уахдаху ля шарикя лях, ляхуль мульк, уа ляхуль хамд, уа Хува 'аля кулли шай ин кадир",
                "Аль хамду лиЛлях уа СубханаЛлах уаль хамду лиЛлях уа ля иляха илля Ллаху уаЛлаху Акьбар уа ля хауля уа ля куввата илля биЛляхиль 'Алиййиль 'Азым",
                "Аллахумма инни ас алюка би анни ашхаду аннакя ля иляха илля Анталь Ахадус-Самаду-Ллязи лям йалид уа лям йуулид уа лям йакуль ляху куфу ван Ахад",
                "Йа Заль Джаляли уаль Икрам",
                "Йа Архамар-Рахимин",
                "Ля иляха илля Анта, субханаКя инни кунтк миназ-залимин",
                "Аллахумма ля иляха илля Ллаху Анталь Маннан, Йа Бади'ас-самавати уаль ард, Йа Заль джаляли уаль икрам",
                "Аллахумма инни ас алюка би анна лякяль хамд. Ля иляха илля Анталь Маннану Йа Бади'ас-самавати уаль ард. Йа Заль джаляли уаль икрам",
                "Аллахумма инни ас алюка би анна лякаль хамд. Ля иляха илля Анталь Маннан. Йа Ханнану Йа Маннан. Йа Бади'ас-самавати уаль ард. Йа Заль джаляли уаль икрам. Йа Хаййу Йа Каййум. Уа Салля Ллаху 'аля Мухаммад уа 'аля аали Мухаммад. Уакды хаджати бирахматиКя йа Архамар-Рахимин",
                "Аллахумма инни ас алюкя бисмиКяль А'зам",
                "Аллахумма инни ас алюка бисмиКя-т-Тахыри-т-Таййибиль Мубаракиль-Аххаби иляйКяль-лязи 'изя ду'ита бихи аджабта уа изя суильта бихи а'тайта уа изя стархимта бихи рахимта уа изя стафриджта бихи фарраджта",
                "Аллахумма инни ад'укя Ллаха уа ад'укя-р-Рахман уа ад'укяль-Барра-р-Рахим уа ад'укя би АсмаиКяль Хусна уа 'алимту минха уа ма лям а'лям ан тагфира лии уа тархам нии"

        };

        translateDua = new String[] {

                "С именем Аллаха, Милостивого ко всем на этом свете и Милосердного лишь на том! \n \n Пророк Салля Ллаху алейхи уа Саллям говорил: «Великое Имя Аллаха столь священно, что когда с этим Именем возносится мольба, она непременно будет принята. Аллах ниспошлет все, о чем раб Его молит с этим Именем",
                "В хадисе со слов Анаса радыяЛлаху анху сообщается:  «Как-то я был рядом с Посланником Аллаха Салля Ллаху алейхи уа Саллям, когда некий человек прочитал ду'а: \n \n О Созидатель небес, о Живой, о Сущий, прошу Тебя о... \n \n Тут Посланник Аллаха сказал мне: \"Знаешь ли ты, что этот человек вознес Аллаху мольбу, упоминая такое великое Имя Его, что эти ду'а, поистине, будут приняты?\"»",
                "Анас ибн Малик радыяЛлаху анху сообщает: «Я был вместе с Посланником Аллаха Салля Ллаху алейхи уа Саллям, когда некий человек читал рядом намаз. В конце намаза он прочитал такое ду'а: \n \n О Аллах! Поистине, прошу у Тебя, притом что вся хвала — Тебе. Нет бога, кроме Тебя. Ты Всемилостивый. Ты Созидатель неба и земли, Обладатель истинного величия и почета, о Живой, о Сущий. \n \n Тогда Посланник Аллаха сказал:  \"Сей верующий вознес ду'а Прекрасными Именами Аллаха. Поистине, Аллах примет его ду'а и ради Прекрасных Имен Своих воздаст ему по желаниям\"» ('Абу Давуд). ",
                "Посланник Аллаха Салля Ллаху алейхи уа Саллям говорил еще об одном ду'а человека, в которой молящийся также упомянул Самое Великое Имя Аллаха: \n \n О Аллах! Поистине, прошу у Тебя, притом что вся хвала — Тебе. Нет бога, кроме Тебя. Ты — Милосердный, Всемилостивый. Ты Созидатель неба и земли, Обладатель истинного величия и почета. Уповаю на Твой Рай и молю защиты от пламени Ада. \n \n Услышав эту ду'а, Посланник Аллаха сказал:  «Он вознес Аллаху Всевышнему мольбу с такими Его Священными Именами, что эта ду'а не будет отвергнута Им. Ради этих Прекрасных Имен Аллах вознаградит его исполнением всех желаний». ",
                "Ибн 'Аббас радыяЛлаху анху сообщает: «Посланник Аллаха  прочитал мне ду'а и сказал, что Аллах не отвергнет мольбы, вознесенной после него. Вот это ду'а: \n \n О Аллах! Поистине, прошу у Тебя, притом что нет бога, кроме Тебя. Ты — Господь семи небес и Господь земли. Поистине, прошу у Тебя, притом что нет бога, кроме Тебя, Милостивого. Ты — Господь семи небес и Господь земли. Поистине, лишь Ты все можешь.",
                "Бурайда радыяЛлаху анху сообщал, как Посланник Аллаха Салля Ллаху алейхи уа Саллям сказал, услышав ду'а одного араба: «Кто, подобно этому человеку, обратится с мольбой к Аллаху Его Священными Именами, тот удостоится исполнения всех своих желаний» (Абу Давуд). Вот это ду'а: \n \n О Аллах! Поистине, прошу у Тебя, свидетельствуя, что ты Аллах, что нет бога, кроме одного Тебя, Единственного, Самодостаточного, Который не родил и не был рожден, Которому нет равных",
                "Мать наша 'А'иша сообщает, что Посланник Аллаха сказал: «Если верующий четыре раза воскликнет Йа Рабби («О Господь!»), Аллах непременно ответит ему Ляббайк! («Слушаю тебя, о раб Мой!»)». \n \n О Господь, О Господь, О Господь, О Господь",
                "Со слов Анаса радыяЛлаху анху сообщается. Как-то Посланник Аллаха Салля Ллаху алейхи уа Саллям после утреннего намаза фаджр подошел к 'А'ише радыяЛлаху анха, которая попросила его: «О Посланник Аллаха! Научи меня такой ду'а с Именем Аллаха, чтобы при вознесении ее все мои желания исполнились». Посланник Аллаха Салля Ллаху алейхи уа Саллям научил ее этой ду'а. Тогда 'А'иша радыяЛлаху анха совершила тахарат, прочитала намаз и в конце вознесла Аллаху ду'а, которой научил ее Пророк Салля Ллаху алейхи уа Саллям: \n \n О Аллах! Поистине, молю Тебя о всех добрых деяниях, известных и неизвестных мне. Поистине, прошу у Тебя Твоим Великим Именем, мольба с Которым будет удовлетворена Тобой и желания будут исполнены",
                "Посланник Аллаха сказал, когда услышал ду'а одного из своих сподвижников: «В этой ду'а есть Самое Великое Имя Аллаха»: \n \n Нет бога, кроме Аллаха. Он — Велик! Нет бога, кроме одного лишь Аллаха, у Которого нет сотоварища. Ему принадлежит владычество, Ему хвала и Он все может. Нет мощи и силы ни у кого, кроме Аллаха",
                "О Аллах! Поистине, прошу у Тебя, притом что вся хвала — Тебе. Нет бога, кроме Тебя, Всеблагого, Всемилостивого. О, Всеблагой, о Всемилостивый. Ты Создатель небес и земли, Обладатель истинного величия и почета!",
                "О Живой, о Сущий! Нет бога, кроме Тебя. Поистине, Ты Пречистый, а я — один из неправедных. О Аллах! Поистине, прошу у Тебя, свидетельствуя, что Ты — Аллах и нет бога, кроме Тебя. Ты — Единый, Вечный. Ты не родил и не был рожден, и нет никого, равного Тебе",
                "Алиф. Лям. Мим. Аллах — нет бога, кроме Него, Живого, Вечно Сущего.\n" +
                        "Господь ваш — лишь Единый Аллах. Нет бога, кроме Аллаха Милостивого и Милосердного. \n" +
                        "Он — Обладатель истинного величия и почета. О Милостивый и Милосердный! \n \n" + "В хадисе со слов 'Асмы бинт Йазид сообщается: «Посланник Аллаха приведенные здесь айаты называл 'исм-и 'а'зам (Абу Давуд)",
                "О Аллах! Поистине, я прошу у Тебя, признавая, что Ты — Аллах [Единственный Бог]. Нет бога, кроме одного лишь Тебя — Единого, Единственного. Ты — Вечный. Ты не родил и не был рожден, и нет никого, равного Тебе",
                "Нет бога, кроме одного лишь Аллаха, у Которого нет сотоварища. Ему принадлежит владычество, Ему хвала и Он все может. Нет бога, кроме Аллаха, и нет сохранности и силы, кроме как у Аллаха Высочайшего, Величайшего. Прошу у Тебя Твоими почитаемыми, высочайшими и великими Именами. О Господь, Господь, Господь мой! Нет бога, кроме одного лишь Аллаха, у Которого нет сотоварища. Ему принадлежит владычество, Ему хвала и Он все может",
                "Хвала Аллаху и слава Аллаху, который пречист от всех недостатков, хвала Аллаху и нет бога, кроме Аллаха. Аллах Велик! Нет сохранности и силы, кроме как у Аллаха, Высокочтимого и Всевеликого",
                "О Аллах! Поистине, прошу у Тебя, свидетельствуя, что нет бога, кроме Тебя, Единого, Вечного, который не родил и не был рожден, и нет никого равного Тебе",
                "Со слов Му'аза ибн Жабаля радыяЛлаху анху сообщается: «Как-то Посланник Аллаха Салля Ллаху алейхи уа Саллям услышал, как один человек, вознося ду'а, упомянул Имя Аллаха: О Обладатель истинного величия и почета, и сказал тому человеку: \"Ду'а твое принято\"».",
                "О Милостивейший из милостивых. \n Тому, кто 3 раза возгласит Йа 'архама-р-рахимин, ангел говорит: \"Проси у Господа своего. Милостивейшего из милостивых, всего, чего пожелаешь\" ",
                "Нет бога, кроме Тебя. Поистине, Ты Пречистый, а я — один из неправедных",
                "В хадисе со слов 'Анаса радыяЛлаху анху сообщается, что Посланник Аллаха Салля Ллаху алейхи уа Саллям вошел как-то в мечеть и услышал, как один из молящихся произнес такое ду'а: О Аллах! Нет бога, кроме Аллаха Всемилостивейшего. О Создатель небес и земли! О Обладатель истинного величия и почета! Посланник Аллаха Салля Ллаху алейхи уа Саллям сказал о нем: «Знаете ли вы, какую ду'а произнес этот сын Адама? Он вознес Аллаху ду'а Его Великим Именем, так что Аллах примет эту ду'а ради этого Имени и исполнит желание молящего»",
                "О Аллах! Поистине, прошу у Тебя, притом что вся хвала — Тебе. Нет бога, кроме Тебя. О Созидатель неба и земли! О Обладатель истинного величия и почета!",
                "О Аллах! Поистине, прошу у Тебя, притом что вся хвала — Тебе, Всемилостивому! О Единственный, о Всемилостивый! О Созидатель неба и земли! О Обладатель истинного величия и почета! О Живой и Вечно Сущий! Благослови Мухаммада и членов семьи Мухаммада. Исполни мою мольбу, о Милостивейший из милостивых!",
                "Пророк Салля Ллаху алейхи уа Саллям говорил, что при обращении к Аллаху с мольбой об исполнении желаний следует говорить: О Аллах! Поистине, прошу у Тебя Великим Именем Твоим",
                "'Аиша радыяЛлаху анха сообщает: «Я слышала, как Посланник Аллаха Салля Ллаху алейхи уа Саллям возносил такое ду'а: О Аллах! Поистине, уповаю на Тебя самым чистым, прекрасным, Священным для Тебя Именем Твоим. Если вознести ду'а этим Именем, Ты непременно примешь его. Ради этого Имени удостоишь всем, о чем Тебя просят [верующие]. Ради этого Имени воздашь от милостей Своих тем, которые уповают на милость Твою. Ради этого Имени дашь защиту от испытаний жизни, устранишь страдания и заботы»",
                "В другой раз Посланник Аллаха Салля Ллаху алейхи уа Саллям сказал 'А'ише радыяЛлаху анха:\n" +
                        "— О 'А'иша, знаешь ли ты, что Аллах научил меня ду'а 'исм-и 'а'зам? Это\n" +
                        "такая ду'а, что если обратиться с ней к Аллаху, то Он исполнит все желания.\n" +
                        "— О Посланник Аллаха, да будут родители мои выкупом за тебя, научи меня\n" +
                        "этму ду'а, — попросила 'А'иша.\n" +
                        "Посланник Аллаха сказал:\n" +
                        "— Тебя нельзя научить ему [этому дуа].\n" +
                        "'А'иша отошла от Пророка , посидела некоторое время в сторонке, а\n" +
                        "затем снова подошла к нему, поцеловала в голову и попросила:\n" +
                        "— О Посланник Аллаха! Научи меня! Тогда\n" +
                        "Посланник Аллаха сказал:\n" +
                        "— Негоже научить тебя этой ду'а, ибо, выучившись ему [этому дуа], ты будешь молить\n" +
                        "Аллаха о мирских делах, а это нехорошо.\n" +
                        "Тут 'А'иша встала, совершила тахарат, затем намаз в 2 рак'ата и вознесла\n" +
                        "Аллаху такую ду'а:\n" +
                        "\n" +
                        "О Аллах! Поистине, молю Тебя Твоими Прекрасными Именами, молю\n" +
                        "Тебя Именем Рахман — Милостивый, именем ал-Барр ар-Рахим —\n" +
                        "Благостный, Милостивый. Молю Тебя всеми Прекрасными Именами,\n" +
                        "которые я знаю и которых не знаю, простить грехи мои и одарить от\n" +
                        "щедрот Своих\n" +
                        "\n" +
                        "Когда 'А'иша радыяЛлаху анха завершила мольбу, Посланник Аллаха Салля Ллаху алейхи уа Саллям сказал ей: «О 'А'иша, ду'а 'Исм-и 'а'зам была в ду'а, которую ты вознесла сейчас»",
        };

        drawerContentList = new String[] {
                "Начало",
                "Дуа 1",
                "Дуа 2",
                "Дуа 3",
                "Дуа 4",
                "Дуа 5",
                "Дуа 6",
                "Дуа 7",
                "Дуа 8",
                "Дуа 9",
                "Дуа 10",
                "Дуа 11",
                "Дуа 12",
                "Дуа 13",
                "Дуа 14",
                "Дуа 15",
                "Дуа 16",
                "Дуа 17",
                "Дуа 18",
                "Дуа 19",
                "Дуа 20",
                "Дуа 21",
                "Дуа 22",
                "Дуа 23"
        };

        init();
        initDrawer();

        b.duaListItem.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        if (dy < 0 && !b.fabDuaInfo.isShown())
                            b.fabDuaInfo.show();
                        else if (dy > 0 && b.fabDuaInfo.isShown())
                            b.fabDuaInfo.hide();
                    }
                }
        );

        b.fabDuaInfo.setOnClickListener(v -> {
            b.drawerLayoutInfo.openDrawer(GravityCompat.START);
        });

        duaAdapter = new DuaAdapter(requireActivity(), duaItemArrayList);
        b.duaListItem.setAdapter(duaAdapter);
        b.duaListItem.setHasFixedSize(false);

        drawerDuaAdapter = new DrawerDuaAdapter(getContext(), duaDrawer, b.duaListItem);
        b.nameDrawerInfo.setAdapter(drawerDuaAdapter);
        b.nameDrawerInfo.setHasFixedSize(false);

        return b.getRoot();
    }

    public void init() {
        for (int i = 0; i < arabicDua.length - 1; ++i) {
            duaItemArrayList.add(new DuaItem(arabicDua[i], transcriptDua[i],
                    translateDua[i], ""));
        }
    }

    public void initDrawer() {
        for(String i : drawerContentList){
            duaDrawer.add(new DrawerDuaContent(i));
        }
    }
}