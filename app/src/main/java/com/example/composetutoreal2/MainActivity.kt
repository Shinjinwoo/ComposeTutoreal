package com.example.composetutoreal2


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.composetutoreal2.ui.theme.ComposeTutorial2Theme



class MainActivity : ComponentActivity() {


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTutorial2Theme() {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
                //OnboardingScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    //var expanded = false // Don't do this!
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp


    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier =  Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
        /*
        Surface 및 Text와 같은 대부분의 Compose UI 요소는 modifier(수정자) 매개변수를 선택적으로 허용한다.
        수정자는 상위 요소 레이아웃 내에서 UI 요소가 배치되고 표시되고 동작하는 방식을 UI 요소에 알려준다.
        */

        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier =  Modifier.weight(1f)
                .padding(bottom =  extraPadding)) {
                Text(text = "Hello,")
                Text(text = "$name!")
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "덜 보기" else "더 보기")
            }
        }
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit,
                     modifier: Modifier = Modifier) {
    // TODO: This state should be hoisted
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,               //화면 중앙에 구성할 수 있도록 하는 옵션
        horizontalAlignment = Alignment.CenterHorizontally      //가로 기준으로 화면 중앙에 구성 할 수있도록 하는 옵션
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")

) {
    /*
    컴포서블 재사용 이유 : UI에 추가하는 구성요소가 많을수록 생성되는 중첩 레벨이 더 많아지기 때문. 너무나 자명한 사실.

    함수 내에서 호출하는 첫 번째 컴포저블로 이 수정자를 전달한다.
    이렇게 하면 호출 사이트가 구성 가능한 함수 외부에서 레이아웃 안내와 동작을 조정할 수 있다.
     */

    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier) {
            if (shouldShowOnboarding) { // Where does this come from?
                OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
            } else {
                for (name in names) {
                    Greeting(name = name)
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeTutorial2Theme {
        MyApp()
        //OnboardingScreen()
    }
}

//@Preview(showBackground = true, widthDp = 320, heightDp = 320)
//@Composable
//fun OnboardPreview() {
//    ComposeTutorial2Theme {
//        OnboardingScreen()
//    }
//}



// Compose의 세 가지 기본 표준 레이아웃 요소는 Column(행), Row(열), Box

//@Preview
//@Composable
//fun PreviewConversation() {
//    ComposeTutorial2Theme {
//        Conversation(SampleData.conversationSample)
//    }
//}


