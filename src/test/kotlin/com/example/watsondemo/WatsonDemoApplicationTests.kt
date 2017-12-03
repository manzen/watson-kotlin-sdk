package com.example.watsondemo

import com.example.watsondemo.controller.WatsonDemoController
import com.example.watsondemo.model.Message
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class WatsonDemoApplicationTests {

	@Autowired
	lateinit var watsonDemoController : WatsonDemoController

	@Test
	fun test() {
		// 初回メッセージ
		var response = watsonDemoController.getMessage(Message("", null))

		println(response.message)
		println(response.context)

		Assert.assertEquals(response.message, "やあ！いろんな国の挨拶やお礼を入力してみてね！")

		// 2回目メッセージ
		response = watsonDemoController.getMessage(Message("こんにちは", response.context))

		println(response.message)
		println(response.context)

		Assert.assertEquals(response.message, "「こんにちは」はあいさつだね。")

	}

}
