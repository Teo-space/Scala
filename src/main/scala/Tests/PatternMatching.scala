package Tests

import scala.util.Random


object PatternMatching {
	def Run(): Unit = {
		val x: Int = Random.nextInt(10)

		val matched = x match
			case 0 => "zero"
			case 1 => "one"
			case 2 => "two"
			case _ => "other"

		println(matched);
		println(matchTest(3));
		println(matchTest(1));

		val someSms = SMS("12345", "Are you there?")
		val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

		println(showNotification(someSms)) // выводит "You got an SMS from 12345! Message: Are you there?"

		println(showNotification(someVoiceRecording))
	}

	def matchTest(x: Int): String = x match
		case 1 => "one"
		case 2 => "two"
		case _ => "other"

	def showNotification(notification: Notification): String =
		notification match
			case Email(sender, title, _) =>
				s"You got an email from $sender with title: $title"
			case SMS(number, message) =>
				s"You got an SMS from $number! Message: $message"
			case VoiceRecording(name, link) =>
				s"You received a Voice Recording from $name! Click the link to hear it: $link"
}



sealed trait Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

