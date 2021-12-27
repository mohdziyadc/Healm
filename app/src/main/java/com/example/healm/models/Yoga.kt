package com.example.healm.models

import androidx.compose.ui.graphics.Color
import com.example.healm.ui.theme.*

data class Yoga(
    val id: Int,
    val sanskrit_name: String,
    val img_url: String,
    val small_description: String,
    val color: Color,
    val videoId: String,
    val level:String,
    val duration: String,
    val link:String,
    val large_description:String,
    val title:String
)

val yogaList = listOf(

    Yoga(
        1, "Hatha Yoga",
        "https://cdn.pixabay.com/photo/2017/02/01/10/20/exercise-2029428_960_720.png",
        "Hatha Yoga class is usually a slow-paced one. This class is perfect for beginners as it gently inducts you into yoga. ",
        LightGreen,
        videoId = "uH2N2gmjhl0",
        level = "Level 1",
        duration = "21 mins",
        link = "https://en.wikipedia.org/wiki/Hatha_yoga",
        large_description = "Hatha Yoga class is usually a slow-paced one. This class is perfect for beginners as it gently inducts you into yoga. Hatha could also be good for anyone who has a difficult time focusing.As long as you're in reasonably good physical condition, you should be well-suited for hatha. Hatha yoga is one of the most popular styles of yoga. It's both a catchall term for many types of yoga that link together physical poses with breathing, as well as an indicator of a slower, more alignment-focused class. Hatha is great for a wide variety of people—especially beginners—as you don't need much prior knowledge or experience to hit the mat. Hatha Yoga is great for beginners and more experienced yogis. Hatha Yoga is great for beginners and more experienced yogis.",
        title = "Hatha Yoga for Beginners"
    ),
    Yoga(
        2, "Vinyasa Flow",
        "https://cdn.pixabay.com/photo/2016/10/18/20/00/exercise-1751254_960_720.png",
        "Vinyasa Flow connects your movements with an inhale, or an exhale. Good class for beginners",
        PurpleLight,
        videoId = "7ciS93shMNQ",
        level = "Level 2",
        duration = "35 mins",
        link = "https://www.verywellfit.com/introduction-to-vinyasa-flow-yoga-4143120",
        large_description = "Vinyasa Flow connects your movements with an inhale, or an exhale. Good class for beginners. Vinyasa stands in opposition to hatha. Hatha classes tend to focus on one pose at a time with rest in between. In contrast, flow classes string poses together to make a sequence. The sequence may be fixed, as in Ashtanga in which the poses are always done in the same order, but most of the time vinyasa teachers have the discretion to arrange the progression of poses in their own ways. In vinyasa yoga, each movement is synchronized to a breath. The breath is given primacy, acting as an anchor as you move from one pose to the next. Vinyasa allows for a lot of variety, but will almost always include sun salutations. Expect to move from pose to pose.",
        title = "Glide with Vinayasa Flow"
    ),
    Yoga(
        3, "Iyengar Yoga",
        "https://cdn.pixabay.com/photo/2018/09/21/23/19/silhouette-3694249_960_720.png",
        "This style tends to accommodate all limitations, and in turn, makes you stable, flexible, and strong.",
        OrangeYellow,
        videoId = "LR72KqH24xM",
        level = "Level 4",
        duration = "25 mins",
        link = "https://en.wikipedia.org/wiki/Iyengar_Yoga",
        large_description = "This style tends to accommodate all limitations, and in turn, makes you stable, flexible, and strong. Iyengar Yoga is a purist style of yoga developed by and named after B.K.S Iyengar in the 1960s. Iyengar Yoga is a very meticulous style of yoga, placing the emphasis on precision and alignment. The practice is all about the details of your breath control (pranayama) and posture (asana) and is excellent for building strength and flexibility. Iyengar yoga is great for learning the subtleties of correct alignment for all ages and abilities. Iyengar yoga is for anyone and everyone. Even though you might feel that an Iyengar class moves at a slower pace than other types of yoga class, you’ll find you have to work hard. It may be methodical but it is far from an easy option!",
        title = "Iyengar Yoga for Intermediates"
    ),
    Yoga(
        4, "Bikram Yoga",
        "https://cdn.pixabay.com/photo/2016/11/05/21/03/exercise-1801507_960_720.png",
        "If you try this, you are sure to sweat it out. It systematically challenges each and every part of the body.",
        PinkRed,
        videoId = "Xc3FOKlCXZM",
        level = "Level 3",
        duration = "30 mins",
        link = "https://en.wikipedia.org/wiki/Bikram_Yoga",
        large_description = "If you try this, you are sure to sweat it out. It systematically challenges each and every part of the body. Bikram yoga is a form of yoga popularized by Bikram Choudhury in the 1970s in California. The patented practice involves repeating the same 26 poses in set cycles over a 90-minute class. The poses were chosen by Choudhury from classic hatha poses and are designed to systematically move fresh, oxygenated blood to 100 percent of your body, to each organ and fiber. The poses — which include triangle pose, tree pose, eagle pose and cobra pose, among other common hatha yoga poses — should be done in a specific, unchanging order, in order to achieve the desired benefits. Bikram yoga follows the 80-20 method and the exhalation method of breathing. Inhale 80 and exhale 20!",
        title = "Breathe with Bikram Yoga"
    ),
    Yoga(
        5, "Ashtanga Yoga",
        "https://cdn.pixabay.com/photo/2018/05/17/19/50/yoga-3409526_960_720.png",
        "If being in a structured, power-packed practice is your thing, this style is for you.",
        BlueGrey,
        videoId = "pzSLOAsd0uU",
        level = "Level 4",
        duration = "30 mins",
        link = "https://en.wikipedia.org/wiki/Ashtanga_(eight_limbs_of_yoga)",
        large_description = "If being in a structured, power-packed practice is your thing, this style is for you. Ashtanga yoga is a system of yoga recorded by the sage Vamana Rishi in the Yoga Korunta, an ancient manuscript. Ashtanga yoga literally means \"eight-limbed yoga,\" as outlined by the sage Patanjali in the Yoga Sutras. The first four limbs—yama, niyama, asana, pranayama—are considered external cleansing practices. According to Pattabhi Jois, defects in the external practices are correctable. However, defects in the internal cleansing practices—pratyahara, dharana, dhyana—are not correctable and can be dangerous to the mind unless the correct Ashtanga yoga method is followed. To perform asana correctly in Ashtanga yoga, one must incorporate the use of vinyasa and tristhana.",
        title = "Ashtanga Yoga for the Brave"
    ),
    Yoga(
        6, "Jivamukti Yoga",
        "https://cdn.pixabay.com/photo/2017/09/07/23/26/exercise-2727123_960_720.png",
        "This style of yoga is a complete package that includes spirituality with physical benefits.",
        LightGrey,
        videoId = "T-hkDBcCunM",
        level = "Level 5",
        duration = "43 mins",
        link = "https://en.wikipedia.org/wiki/Jivamukti_Yoga",
        large_description = "This style of yoga is a complete package that includes spirituality with physical benefits. Jivamukti yoga was devised in 1984 by Life and Gannon. It is founded upon traditional yoga. Jivamukti is a vinyasa style practice where the asana is usually quite vigorous, though classes can also be lighthearted and fun. One of the strongest currents in Jivamukti's philosophy is a strict interpretation of the yama ahimsa, which means non-violence. Accordingly, Jivamukti teachers advocate, sometimes strongly, for a vegan diet. Jivamukti Yoga incorporates meditation, chanting, pranayama, music, and philosophy into vigorous poses of its practice. It is the only yoga form where its practitioner can modify the postures of asanas according to the reaction of your body. ",
        title = "Awaken with Jivamukti Yoga"
    ),
    Yoga(
        7, "Kundalini Yoga",
        "https://cdn.pixabay.com/photo/2014/04/03/10/10/dance-310022_960_720.png",
        "Kundalini Yoga tends to be physically demanding. It is also mentally challenging.",
        LightGreen,
        videoId = "-DO_GgchYPA",
        level = "Level 4",
        duration = "34 mins",
        link = "https://en.wikipedia.org/wiki/Kundalini_yoga",
        large_description = "Kundalini Yoga tends to be physically demanding. It is also mentally challenging. Kundalini yoga is a form of yoga that involves chanting, singing, breathing exercises, and repetitive poses. Its purpose is to activate your Kundalini energy, or shakti. This is a spiritual energy that’s said to be located at the base of your spine. As Kundalini yoga awakens this energy, it’s supposed to enhance your awareness and help you move past your ego. Sometimes, the practice is also called \"yoga of awareness\". It still involves physical movements, but they aren’t the primary focus. This is different from hatha or vinyasa yoga, for example, which both revolve around physical poses. Kundalini yoga is also more precise and repetitive.",
        title = "Kundalini Yoga for Experienced"

    ),
    Yoga(
        8, "Anusara Yoga",
        "https://cdn.pixabay.com/photo/2017/02/01/11/02/boy-2029661_960_720.png",
        "If you are new to yoga and are up for some real soul-searching, this is something you must try.",
        OrangeYellow,
        videoId = "r1DCAJVwGEI",
        level = "Level 2",
        duration = "33 mins",
        link = "https://www.ekhartyoga.com/resources/styles/anusara-yoga",
        large_description = "If you are new to yoga and are up for some real soul-searching, this is something you must try. Anusara yoga is a modern-day Hatha yoga system founded by John Friend. Anusara means “flowing with grace,” “going with the flow,” “following your heart.” Anusara Yoga is rooted in a non-dual Tantric philosophy that we are all inherently good. It draws from this that life is a gift that we are invited to remember and celebrate in our yoga practice. Anusara yoga is designed for students of any level or ability. There are over 250 poses included in Anusara Yoga but there are no set postural routines. When you practise with an intention and intelligent awareness of the body and mind, the groundwork is laid down to structurally shift and improve.",
        title = "Peace with Anusara Yoga"
    ),
    Yoga(
        9, "Yin Yoga",
        "https://cdn.pixabay.com/photo/2018/06/03/08/07/yoga-3449916_960_720.png",
        "You will become more patient, and focus on your breathing in a thoughtful way. This style of yoga is incredibly relaxing.",
        PurpleLight,
        videoId = "3YOYyQ8cb5c",
        level = "Level 3",
        duration = "39 mins",
        link = "https://www.mindbodygreen.com/0-5037/Yin-Yoga-101-What-You-Need-to-Know.html",
        large_description = "You will become more patient, and focus on your breathing in a thoughtful way. This style of yoga is incredibly relaxing. Yin yoga works deeply into our body with passive, longer-held poses. It targets the deepest tissues of the body, our connective tissues – ligaments, joints, bones, the deep fascia networks of the body and the meridians. This is contrast to a Yang yoga practice such as Vinyasa yoga which targets the muscles. Energetically, Yin yoga improves the energy flow, enhancing the flow of chi in the organs. To be healthy, we need healthy organs as well as healthy muscles. Yin yoga also offers wonderful emotional and mental health benefits. Yin yoga is based on the Taoist concept of yin and yang, opposite and complementary principles in nature.",
        title = "Relax with Yin Yoga"
    )
//    Yoga(
//        10, "Uttanasana Yoga",
//        "https://www.dropbox.com/s/sjqfq99pqpelv4v/forwardfoldshoulderstretch.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        11, "Anjaneyasana Yoga",
//        "",
//        ""
//    ),
//    Yoga(
//        12, "Phalakasana Yoga",
//        "https://www.dropbox.com/s/jg6ge8zpaltx10f/plank.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        13, "Halasana Yoga",
//        "https://www.dropbox.com/s/zi9231wbajm6d2m/plow.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        14, "Padmasana Yoga",
//        "https://www.dropbox.com/s/0oylivjwzuj5fnp/seatedORlotus.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        15, "Vasisthasana Yoga",
//        "https://www.dropbox.com/s/w35ciia4u570xj8/sideplank.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        16, "Hanumanasana Yoga",
//        "https://www.dropbox.com/s/u8dxhc41hjfcxj6/splits.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        17, "Malasana Yoga",
//        "https://www.dropbox.com/s/ntrwtdlr6tdkdxz/squat.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        18, "Uttanasana Yoga",
//        "https://www.dropbox.com/s/u09snmhtposvaq0/standingforwardfold.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        19, "Vrksasana Yoga",
//        "https://www.dropbox.com/s/mn2ktlihp12mtfa/tree.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        20, "Trikonasana Yoga",
//        "https://www.dropbox.com/s/l41pfqjwmjoy5os/triangle.svg?raw=1",
//        ""
//    ),
//    Yoga(
//        21, "Camatkarasana Yoga",
//        "https://www.dropbox.com/s/d1dbdvo4l7xry4w/downdogflip.svg?raw=1",
//        ""
//    ),


)