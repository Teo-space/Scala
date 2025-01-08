package Tests.OOP

object CaseClass {
	def Run(): Unit = {
		case class Message(sender: String, recipient: String, body: String)

		val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
		val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
		val messagesAreTheSame = message2 == message3

		println(s"messagesAreTheSame : ${messagesAreTheSame}")
	}
}

object CaseClass2
	def Run(): Unit =
		case class Message(sender: String, recipient: String, body: String)

		val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
		val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
		val messagesAreTheSame = message2 == message3

		println(s"messagesAreTheSame : ${messagesAreTheSame}")

