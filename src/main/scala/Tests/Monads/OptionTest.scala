package Tests.Monads

import scala.util.{Try, Failure, Success}

object OptionTest {
	def Run(): Unit = {
		val optionValue: Option[String] = Some("Value")
		println(optionValue)

		optionValue match{
			case Some(v) => println(v)
			case None => println("None")
		}

		println(f"optionValue (isDefined:${optionValue.isDefined}, nonEmpty: ${optionValue.nonEmpty}, isEmpty: ${optionValue.isEmpty})")

		val optionNone: Option[String] = None
		println(optionNone)

		println(f"getOrElse: ${optionNone.getOrElse("default")}")
	}
}
