package com.example.cookpedia.ui.loader

import androidx.compose.runtime.*
import com.airbnb.lottie.compose.*
import com.example.cookpedia.R

@Composable
fun LoaderScreen(){
    var isPlaying by remember {
        mutableStateOf(true)
    }

    // for speed
    var speed by remember {
        mutableStateOf(1f)
    }

    // remember lottie composition, which
// accepts the lottie composition result
    val composition by rememberLottieComposition(

        LottieCompositionSpec
            // here `code` is the file name of lottie file
            // use it accordingly
            .RawRes(R.raw.loader)
    )

    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which it was paused
        restartOnPlay = false

    )

    LottieAnimation(
        composition = composition,
        progress = progress)
}