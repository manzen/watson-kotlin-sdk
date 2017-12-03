package com.example.watsondemo.controller

import com.example.watsondemo.model.Message
import com.ibm.watson.developer_cloud.conversation.v1.Conversation
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions
import org.springframework.web.bind.annotation.*





@RestController
@RequestMapping("/")
class WatsonDemoController {

  @PostMapping("/message")
  fun getMessage(@RequestBody message: Message) : Message {
    val service = Conversation(Conversation.VERSION_DATE_2016_07_11)

    service.setUsernameAndPassword("your name", "your password")

    var newMessageOptions = MessageOptions.Builder()
      .workspaceId("your workspace id")
      .input(InputData.Builder(message.message).build())
      .context(message.context)
      .build()

    var response = service.message(newMessageOptions).execute()

    return Message(response.output.text.get(0), response.context)
  }
}