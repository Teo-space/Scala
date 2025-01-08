package Tests.OOP


object Class
{
	def Run(): Unit =
	{
		class Message(sender: String, recipient: String, body: String)

		val messageF = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
		val messageS = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")

		println(s"messagesAreTheSame : ${messageF == messageS}")//False
	}
}