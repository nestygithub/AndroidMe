package com.chiki.androidme.data

import com.chiki.androidme.R

class AndroidImageAssets(){

    //Available heads for the game
    val heads = listOf(
        BodyPart(R.drawable.head1),
        BodyPart(R.drawable.head2),
        BodyPart(R.drawable.head3),
        BodyPart(R.drawable.head4),
        BodyPart(R.drawable.head5),
        BodyPart(R.drawable.head6),
        BodyPart(R.drawable.head7),
        BodyPart(R.drawable.head8),
        BodyPart(R.drawable.head9),
        BodyPart(R.drawable.head10),
        BodyPart(R.drawable.head11),
        BodyPart(R.drawable.head12)
    )

    //Available bodies for the game
    val bodies = listOf(
        BodyPart(R.drawable.body1),
        BodyPart(R.drawable.body2),
        BodyPart(R.drawable.body3),
        BodyPart(R.drawable.body4),
        BodyPart(R.drawable.body5),
        BodyPart(R.drawable.body6),
        BodyPart(R.drawable.body7),
        BodyPart(R.drawable.body8),
        BodyPart(R.drawable.body9),
        BodyPart(R.drawable.body10),
        BodyPart(R.drawable.body11),
        BodyPart(R.drawable.body12),
    )

    //Available legs for the game
    val legs = listOf(
        BodyPart(R.drawable.legs1),
        BodyPart(R.drawable.legs2),
        BodyPart(R.drawable.legs3),
        BodyPart(R.drawable.legs4),
        BodyPart(R.drawable.legs5),
        BodyPart(R.drawable.legs6),
        BodyPart(R.drawable.legs7),
        BodyPart(R.drawable.legs8),
        BodyPart(R.drawable.legs9),
        BodyPart(R.drawable.legs10),
        BodyPart(R.drawable.legs11),
        BodyPart(R.drawable.legs12),
    )

    //All Body Parts including heads,bodies and legs
    val all:List<BodyPart> = heads+bodies+legs
}