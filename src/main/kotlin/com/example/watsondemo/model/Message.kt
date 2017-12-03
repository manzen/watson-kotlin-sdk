package com.example.watsondemo.model

import com.ibm.watson.developer_cloud.conversation.v1.model.Context

class Message(
  var message: String = "",
  var context: Context? = null
)