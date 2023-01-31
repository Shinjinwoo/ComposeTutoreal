package com.example.composetutoreal2.codelab_basic

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class codeLabScreen {

}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    //var expanded = false // Don't do this!
    val expanded = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState (
        if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    var test = name.toInt() + 1

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
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))) {
                Text(text = "Hello,")
                Text(text = "$test!")
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "덜 보기" else "더 보기")
            }
        }
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit,
                     modifier: Modifier = Modifier
) {
    // TODO: This state should be hoisted

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

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
    names: List<String> = listOf("World", "Compose"
    )
) {
    /*
    컴포서블 재사용 이유 : UI에 추가하는 구성요소가 많을수록 생성되는 중첩 레벨이 더 많아지기 때문. 너무나 자명한 사실.

    함수 내에서 호출하는 첫 번째 컴포저블로 이 수정자를 전달한다.
    이렇게 하면 호출 사이트가 구성 가능한 함수 외부에서 레이아웃 안내와 동작을 조정할 수 있다.
     */

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier) {
            if (shouldShowOnboarding) { // Where does this come from?
                OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
            } else {
                for (name in names) {
                    Greetings()
                }
            }
        }
    }
}