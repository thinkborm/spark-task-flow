package com.thinkborm.task

import com.thinkborm.properties.TaskProperties
import org.apache.spark.sql.SparkSession
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestTask extends Task {


  protected val LOGGER: Logger = LoggerFactory.getLogger(classOf[TestTask])
  /**
    * 具体的业务逻辑
    */
  override def doTask(): Unit = {
    LOGGER.info("task test start")

    // TODO: 具体的业务逻辑
    val df = spark.sql("select 1 as a ,2 as b")
    df.show()
    LOGGER.info("task test stop")
  }

}
