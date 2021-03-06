package com.thinkborm.model.key.statistic

import com.thinkborm.model.key.Key

class TimeApiStatusKey(_time: String, _api: String, _status: String) extends Key {

  // time, 到秒的String
  var time: String = _time
  // api
  var api: String = _api
  // status
  var status: String = _status

  def canEqual(other: Any): Boolean = other.isInstanceOf[TimeApiStatusKey]

  override def equals(other: Any): Boolean = other match {
    case that: TimeApiStatusKey =>
      (that canEqual this) &&
        time == that.time &&
        api == that.api &&
        status == that.status
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(time, api, status)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"TimeApiStatusKey($time, $api, $status)"
}
