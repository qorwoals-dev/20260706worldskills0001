package com.example.wdskills002.screen
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wdskills002.R
import com.example.wdskills002.core.campingmate
import com.example.wdskills002.ui.theme.Wdskills002Theme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun Introscreen(onStartClick: () -> Unit) {
    val listColors = listOf(Color.Green, Color.Red, Color.White)
    var visible by remember { mutableStateOf(false) }

    // 화면이 켜지면 애니메이션 시작 트리거
    LaunchedEffect(Unit) {
        visible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listColors)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        // 1. 앱 로고 및 타이틀 영역 (1.5초 흐릿하게 페이드인)
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 1500))
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.app_icon),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(8.dp)) // 로고와 텍스트 사이 간격
                Text("Camping Mate", fontSize = 25.sp)
            }
        }

        Spacer(modifier = Modifier.height(70.dp))

        // 2. 이미지 모음 영역 (2.5초 페이드인)
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 2500))
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img4),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // 이미지 사이 간격
                    Image(
                        painter = painterResource(R.drawable.img4),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(R.drawable.img4),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(R.drawable.img6),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        // 3. 홍보 문구 영역 (2.5초 페이드인)
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 2500))
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("나에게 맞는", fontSize = 25.sp)
                Text("캠핑을 찾아보세요.", fontSize = 25.sp)
            }
        }

        Spacer(modifier = Modifier.height(70.dp))

        // 4. 시작하기 버튼 영역 (3초 페이드인)
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 3000))
        ) {
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(300.dp),
                onClick = {onStartClick()}
            ) {
                Text("시작하기", fontSize = 25.sp)
                Spacer(modifier = Modifier.width(8.dp)) // 글자와 화살표 사이 간격
                Image(
                    painter = painterResource(R.drawable.arrowgo),
                    contentDescription = null
                )
            }
        }
    }
}
@Composable
fun Setupscreen(startStep: Int = 0) {
    var visible by remember { mutableStateOf(false) }
    var step by remember { mutableStateOf(startStep) }
    when(step){
        0 -> Introscreen(onStartClick = {step = 1} )
        1 -> NameScr(
            onNext = { step = 2},
            onBack = { step = 0}
        )
        2 -> CampExp(
            onNext = {step = 3},
            onBack = {step = 1}
        )
        3 -> CampPerson(
            onNext = {step = 4},
            onBack = {step = 2}
        )
        4 -> PreType(
            onNext = {step = 5},
            onBack = {step = 3}
        )
        5 -> Checkin(
            onNext = {step = 6},
            onBack = {step = 4}
        )
        6 -> Preact(
            onNext = {step = 7},
            onBack = {step = 5}
        )

        7 -> Info(
            onNext = {step = 8},
            onBack = {step = 6}
        )
        8 -> HomeCon()
    }

}
@Composable
fun progressbar(progress : Float){
    LinearProgressIndicator(
        modifier = Modifier
            .height(28.dp)
            .padding(10.dp)
            .fillMaxWidth(),
        color = Color.White,
        progress = progress
    )

}



@Composable
fun NameScr(onBack: () -> Unit, onNext: () -> Unit){
    var context = LocalContext.current
    var username by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Camping Mate", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.img3),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "캠핑 닉네임을 입력해주세요.", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(60.dp))
        TextField(
            value = username,
            onValueChange = {username = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                ),
            placeholder = { Text("닉네임을 입력하세요") } // ?
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
                    .padding(start = 20.dp),
                onClick = {
                    onBack()
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = null
                )
                Text("이전", fontSize = 20.sp)

            }
            if(username.isNotEmpty()){
                Button(
                    modifier = Modifier
                        .height(60.dp)
                        .width(150.dp)
                        .padding(end = 20.dp),
                    onClick = {
                        if(username.length < 2 || username.length > 12){
                            Toast.makeText(context,"닉네임은 2자 ~ 12자 까지 가능", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            campingmate.name = username
                            onNext()
                        }

                    }
                ) {
                    Text("다음", fontSize = 20.sp)
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }



        }
        Spacer(modifier = Modifier.height(80.dp))
        progressbar(progress = 0.25F)

    }
}
@Composable()
fun CampExp(onNext: () -> Unit, onBack: () -> Unit){
    var campexp by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Camping Mate", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "캠핑 경험을 선택해주세요.", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .height(100.dp)
                .width(330.dp),
            onClick = {
                campexp = "캠핑초보"

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(campexp == "캠핑초보") Color.White else Color.Gray
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.img7),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "캠핑 초보",
                fontSize = 35.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .height(100.dp)
                .width(330.dp),
            onClick = {
                campexp = "캠핑 보통"

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(campexp == "캠핑 보통") Color.White else Color.Gray
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.img3),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "캠핑 보통",
                fontSize = 35.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .height(100.dp)
                .width(330.dp),
            onClick = {
                campexp = "캠핑 숙련"

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(campexp == "캠핑 숙련") Color.White else Color.Gray
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.img4),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "캠핑 초보",
                fontSize = 35.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
                    .padding(start = 20.dp),
                onClick = {
                    onBack()
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = null
                )
                Text("이전", fontSize = 20.sp)

            }
            if(campexp.isNotEmpty()){
                Button(
                    modifier = Modifier
                        .height(60.dp)
                        .width(150.dp)
                        .padding(end = 20.dp),
                    onClick = {
                        campingmate.campexp = campexp
                        onNext()
                    }
                ) {
                    Text("다음", fontSize = 25.sp)
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }


        }

        Spacer(modifier = Modifier.height(30.dp))
        progressbar(progress = 0.25F)

    }

}
@Composable()
fun CampPerson(onNext: () -> Unit, onBack: () -> Unit){
    var preson by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Camping Mate", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "동반 인원을 선택해주세요.", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .height(200.dp)
                    .width(80.dp),
                onClick = {
                    if(preson > 1)
                    preson--

                }
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.minus),
                        contentDescription = null
                    )
                    Text("감소")

                }

            }
            Spacer(modifier = Modifier.width(60.dp))
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(preson.toString(), fontSize = 65.sp)
                Text("인원 수  표시 \n    텍스트", fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.width(50.dp))

            Button(
                modifier = Modifier
                    .padding(10.dp)
                    .height(200.dp)
                    .width(80.dp),
                onClick = {
                    if(preson < 6){
                        preson++
                    }


                }
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = null
                    )
                    Text("증가")

                }

            }



        }

        Spacer(modifier = Modifier.height(30.dp))


        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
                    .padding(start = 20.dp),
                onClick = {
                    onBack()
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = null
                )
                Text("이전", fontSize = 20.sp)

            }
            if(preson > 0){
                Button(
                    modifier = Modifier
                        .height(60.dp)
                        .width(150.dp)
                        .padding(end = 20.dp),
                    onClick = {
                        campingmate.personc = preson
                        onNext()
                    }
                ) {
                    Text("다음", fontSize = 20.sp)
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }


        }

        Spacer(modifier = Modifier.height(120.dp))
        progressbar(progress = 0.25F)

    }

}
@Composable()
fun PreType(onNext: () -> Unit, onBack: () -> Unit){
    var pretype by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Camping Mate", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "선호 숙박 유형을 선택해주세요.", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(155.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    pretype = "오토캠핑"

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(pretype == "오토캠핑") Color.White else Color.Gray
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(17.dp))
                    Image(
                        painter = painterResource(R.drawable.img7),
                        contentDescription = null,
                    )
                    Text(
                        text = "오토캠핑",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }

            }

            Button(
                modifier = Modifier
                    .height(155.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    pretype = "글램핑"

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(pretype == "글램핑") Color.White else Color.Gray
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(17.dp))
                    Image(
                        painter = painterResource(R.drawable.img4),
                        contentDescription = null,
                    )
                    Text(
                        text = "글램핑",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }

            }

        }
        Row(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(155.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    pretype = "카라반"

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(pretype == "카라반") Color.White else Color.Gray
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(17.dp))
                    Image(
                        painter = painterResource(R.drawable.img5),
                        contentDescription = null,
                    )
                    Text(
                        text = "카라반",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }

            }

            Button(
                modifier = Modifier
                    .height(155.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    pretype = "차박"

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(pretype == "차박") Color.White else Color.Gray
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(17.dp))
                    Image(
                        painter = painterResource(R.drawable.img6),
                        contentDescription = null,
                    )
                    Text(
                        text = "차박",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }

            }

        }
        Spacer(modifier = Modifier.height(10.dp))


        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
                    .padding(start = 20.dp),
                onClick = {
                    onBack()
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = null
                )
                Text("이전", fontSize = 20.sp)

            }
            if(pretype.isNotEmpty()){
                Button(
                    modifier = Modifier
                        .height(60.dp)
                        .width(150.dp)
                        .padding(end = 20.dp),
                    onClick = {
                        campingmate.pretype = pretype
                        onNext()
                    }
                ) {
                    Text("다음", fontSize = 20.sp)
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }


        }

        Spacer(modifier = Modifier.height(30.dp))
        progressbar(progress = 0.25F)

    }

}
@Composable
fun Checkin(onNext: () -> Unit, onBack: () -> Unit) {
    // 1. 상태 관리: 현재 화면에 보여줄 기준 날짜 (기본값: 오늘)
    var focusDay by remember { mutableStateOf(LocalDate.now()) }

    // 2. 상태 관리: 사용자가 클릭해서 선택한 날짜 (초기값 없음)
    var selectDay by remember { mutableStateOf<LocalDate?>(null) }

    // 토스트 메시지를 띄우기 위한 컨텍스트 가져오기
    val context = LocalContext.current
    // 전체 레이아웃 시작
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Camping Mate", fontSize = 20.sp)
        // 제목 텍스트
        Text(
            text = "체크인 날짜를 선택해주세요.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 3. 월 이동 컨트롤러 (이전달 - 현재년월 - 다음달)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 이전 달로 이동 버튼
            Button(
                onClick = {},
                modifier = Modifier
            ) { }

            // 현재 보고 있는 년.월 표시 (예: 2026.05)
            Text(
                text = focusDay.format(DateTimeFormatter.ofPattern("yyyy.MM")),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // 다음 달로 이동 버튼
            Button(
                onClick = {}
            ) {

            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 4. 요일 헤더 (일~토)
        Row(modifier = Modifier.fillMaxWidth()) {
            val weekdays = listOf("일", "월", "화", "수", "목", "금", "토")
            weekdays.forEach { day ->
                Box(
                    modifier = Modifier.weight(1f), // 7칸을 동일한 비율로 나눔
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        fontSize = 16.sp,
                        // 일요일은 빨강, 토요일은 파랑, 나머지는 검정
                        color = when(day) {
                            "일" -> Color.Red
                            "토" -> Color.Blue
                            else -> Color.Black
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // --- 여기서부터 달력 그리드 계산 시작 ---

        // 5. 이번 달의 1일 날짜 객체 생성
        val firstDayOfMonth = focusDay.withDayOfMonth(1)

        // 6. 시작 요일 오프셋 계산 (일요일=0, 월요일=1 ... 토요일=6)
        // dayOfWeek.value는 월(1)~일(7)을 주므로 %7 처리를 통해 일요일을 0으로 만듦
        val sPad = firstDayOfMonth.dayOfWeek.value % 7

        // 7. 이번 달이 총 며칠인지 계산 (28, 30, 31 등)
        val daysInMonth = focusDay.lengthOfMonth()

        // 8. 달력 격자 (7열 고정)
        LazyVerticalGrid(
            columns = GridCells.Fixed(7), // 무조건 7개씩 한 줄
            modifier = Modifier.fillMaxWidth()
        ) {
            // 9. 1일 시작 전 빈칸들 생성 (sPad 개수만큼)
            items(sPad) {
                Box(
                    modifier = Modifier
                        .aspectRatio(1f) // 정사각형 유지
                        .border(0.5.dp, Color.Black.copy(alpha = 0.1f)) // 아주 연한 테두리
                )
            }

            // 10. 실제 날짜들 생성 (1일부터 daysInMonth까지)
            items(daysInMonth) { index ->
                val dayNum = index + 1 // 인덱스는 0부터 시작하므로 +1
                val currentLocalDate = focusDay.withDayOfMonth(dayNum) // 해당 칸의 실제 날짜 객체
                val isSelected = selectDay == currentLocalDate // 사용자가 선택한 날짜인지 확인
                val isToday = currentLocalDate == LocalDate.now() // 오늘 날짜인지 확인

                Box(
                    modifier = Modifier
                        .aspectRatio(1f) // 정사각형 유지
                        .background(
                            // 선택된 날짜면 연한 파란색 배경, 아니면 투명
                            if (isSelected) Color.Blue.copy(alpha = 0.2f) else Color.Transparent
                        )
                        .border(0.5.dp, Color.Black.copy(alpha = 0.1f)) // 격자무늬 선
                        .clickable {
                            // 11. 예외 처리: 오늘보다 이전 날짜를 클릭하면 경고
                            if (currentLocalDate.isBefore(LocalDate.now())) {
                                Toast.makeText(context, "예약은 과거를 선택할 수 없습니다", Toast.LENGTH_SHORT).show()
                            } else {
                                // 정상 날짜면 선택 상태 업데이트
                                selectDay = currentLocalDate
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = dayNum.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        // 선택된 날짜는 파란색, 오늘 날짜는 강조, 나머지는 검정
                        color = when {
                            isSelected -> Color.Blue
                            isToday -> Color(0xFF008000) // 오늘 날짜는 초록색 등으로 포인트
                            else -> Color.Black
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
                    .padding(start = 20.dp),
                onClick = {
                    onBack()
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = null
                )
                Text("이전", fontSize = 20.sp)

            }
            if(selectDay.toString().isNotEmpty()){
                Button(
                    modifier = Modifier
                        .height(60.dp)
                        .width(150.dp)
                        .padding(end = 20.dp),
                    onClick = {
                        onNext()
                    }
                ) {
                    Text("다음", fontSize = 20.sp)
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }


        }

        Spacer(modifier = Modifier.height(20.dp))

        progressbar(progress = 0.7F)


    }
}
@Composable
fun Preact(onNext: () -> Unit, onBack: () -> Unit){
    var preact by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Camping Mate", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "선호 활동을 선택해주세요.", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                preact = "힐링"

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(preact == "캠핑초보") Color.White else Color.Gray
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.img7),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "힐링",
                fontSize = 35.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                preact = "바베큐"

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(preact == "바베큐") Color.White else Color.Gray
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.img6),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "바베큐",
                fontSize = 35.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                preact = "액티비티"

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(preact == "액티비티") Color.White else Color.Gray
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.img4),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "액티비티",
                fontSize = 35.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                preact = "반려동물 동반"

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(preact == "반려동물 동반") Color.White else Color.Gray
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.img3),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "반려동물 동반",
                fontSize = 35.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.height(60.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
                    .padding(start = 20.dp),
                onClick = {
                    onBack()
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = null
                )
                Text("이전", fontSize = 25.sp)

            }
            if(preact.isNotEmpty()){
                Button(
                    modifier = Modifier
                        .height(60.dp)
                        .width(150.dp)
                        .padding(end = 20.dp),
                    onClick = {
                        campingmate.preact = preact
                        onNext()
                    }
                ) {
                    Text("다음", fontSize = 25.sp)
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }


        }

        Spacer(modifier = Modifier.height(30.dp))
        progressbar(progress = 0.25F)

    }

}
@Composable
fun Info(onNext: () -> Unit, onBack: () -> Unit){
    var preact by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Camping Mate", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(350.dp),
            onClick = {
            },
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.img7),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "캠핑 닉네임",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(40.dp))
            Text(campingmate.name)
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null,
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(350.dp),
            onClick = {
            },
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.img6),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "캠핑 경험",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(40.dp))
            Text(campingmate.campexp)
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null,
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(350.dp),
            onClick = {
            },
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.img4),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "동반 인원",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(40.dp))
            Text(campingmate.personc.toString() + "명")
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null,
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(350.dp),
            onClick = {
            },
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.img7),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "숙박 유형",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(40.dp))
            Text(campingmate.pretype)
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null,
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(350.dp),
            onClick = {
            },
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.img3),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "체크인 날짜",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(40.dp))
            Text("202일")
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null,
            )

        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(350.dp),
            onClick = {
            },
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.img5),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "선호 활동",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(40.dp))
            Text(campingmate.preact)
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier
                .height(60.dp)
                .width(300.dp)
                .padding(end = 20.dp),
            onClick = {
                onNext()
            }
        ) {
            Spacer(modifier = Modifier.width(70.dp))
            Text("시작하기", fontSize = 25.sp)
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 50.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        progressbar(progress = 1.25F)

    }

}

@Preview(showBackground = true)
@Composable
fun NamePreview() {
    Setupscreen(startStep = 7)

}