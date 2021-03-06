/*
 * Copyright (C) 2015 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.sparta.plugin.input.kafka

import com.stratio.sparta.plugin.input.kafka.KafkaInput
import com.stratio.sparta.sdk.properties.JsoneyString
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class KafkaDirectInputTest extends WordSpec with Matchers {
  "KafkaDirect Input" should {
    "Topics match " in {
      val conn =
        """[{"topic":"test","partition":"1"},
          |{"topic":"test2","partition":"2"},{"topic":"test3","partition":"3"}]""".stripMargin
      val input = new KafkaInput(Map("topics" -> JsoneyString(conn)))
      val topicsMap = input.extractTopicsMap()
      topicsMap.size should be (3)
    }
  }

}
