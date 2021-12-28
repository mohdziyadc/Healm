package com.example.healm.models

import androidx.annotation.DrawableRes
import com.example.healm.R

data class Meditation(
    val id: Int,
    val name: String,
    val desc: String,
    val time: Int,
    @DrawableRes val img: Int
)

val MeditationList = listOf(
    Meditation(
        id = 1,
        name = "Breather",
        desc = "An Intro to Meditation. Relax and inhale to start.",
        time = 12,
        img = R.drawable.breather_img
    ),
    Meditation(
        id = 2,
        name = "Love-Kind Meditation",
        desc = "Direct positive energy and goodwill to ourselves and others.",
        time = 15,
        img = R.drawable.love_img
    ),
    Meditation(
        id = 3,
        name = "Flower Meditation",
        desc = "Ground yourself in the present and connect to life vitality and love.",
        time = 10,
        img = R.drawable.flower_img
    ),
    Meditation(
        id = 4,
        name = "Chakra Meditation",
        desc = "Balance yourself by keeping your body's chakras open, aligned, and fluid.",
        time = 17,
        img = R.drawable.chakra_img
    ),
    Meditation(
        id = 5,
        name = "Skillful Compassion",
        desc = "Open your hearts and minds for the benefit of other people and feel happiness.",
        time = 20,
        img = R.drawable.skillful_img
    ),
    Meditation(
        id = 6,
        name = "Reflection",
        desc = "Become aware of our own state of being. Mindful reflection brings us back to ourselves.",
        time = 13,
        img = R.drawable.reflection_img
    ),
    Meditation(
        id = 7,
        name = "Focused Attention",
        desc = "Anchor the mind and maintain awareness by focusing on your breath.",
        time = 21,
        img = R.drawable.focused_attention_img
    ),
    Meditation(
        id = 8,
        name = "Zen Meditation",
        desc = "Foster a sense of presence and alertness by following this ancient method.",
        time = 17,
        img = R.drawable.zen_img
    )

)
