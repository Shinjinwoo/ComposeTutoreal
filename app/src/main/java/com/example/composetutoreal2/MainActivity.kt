package com.example.composetutoreal2


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

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
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier =  Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
        /*
        Surface 및 Text와 같은 대부분의 Compose UI 요소는 modifier(수정자) 매개변수를 선택적으로 허용한다.
        수정자는 상위 요소 레이아웃 내에서 UI 요소가 배치되고 표시되고 동작하는 방식을 UI 요소에 알려준다.
        */
        Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
            Text(text = "Hello")
            Text(text = "$name!")
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

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
}

    @Preview(showBackground = true, widthDp = 320)
    @Composable
    fun DefaultPreview() {
        ComposeTutorial2Theme {
            MyApp()
        }
    }



// Compose의 세 가지 기본 표준 레이아웃 요소는 Column(행), Row(열), Box


//@Preview
//@Composable
//fun PreviewConversation() {
//    ComposeTutorial2Theme {
//        Conversation(SampleData.conversationSample)
//    }
//}


