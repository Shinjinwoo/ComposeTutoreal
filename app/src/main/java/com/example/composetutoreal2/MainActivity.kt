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

import com.orhanobut.logger.Logger



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
        color = MaterialTheme.colorScheme.primary
    ) {
        /*
        Surface 및 Text와 같은 대부분의 Compose UI 요소는 modifier(수정자) 매개변수를 선택적으로 허용한다.
        수정자는 상위 요소 레이아웃 내에서 UI 요소가 배치되고 표시되고 동작하는 방식을 UI 요소에 알려준다.
        */
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    /*
    컴포서블 재사용 이유 : UI에 추가하는 구성요소가 많을수록 생성되는 중첩 레벨이 더 많아지기 때문. 너무나 자명한 사실.

    함수 내에서 호출하는 첫 번째 컴포저블로 이 수정자를 전달한다.
    이렇게 하면 호출 사이트가 구성 가능한 함수 외부에서 레이아웃 안내와 동작을 조정할 수 있다.
     */
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorial2Theme {
        MyApp()
    }
}



//@Preview
//@Composable
//fun PreviewConversation() {
//    ComposeTutorial2Theme {
//        Conversation(SampleData.conversationSample)
//    }
//}


