import java.util.Scanner

data class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())
data class Note(val title: String, val content: String)

abstract class Menu(private val title: String) {
    protected abstract val options: List<Pair<String, () -> Unit>>

    fun show() {
        while (true) {
            println(title)
            options.forEachIndexed { index, option ->
                println("$index. ${option.first}")
            }
            println("${options.size}. Назад")

            val choice = inputInt()
            if (choice in options.indices) {
                options[choice].second.invoke()
            } else if (choice == options.size) {
                return
            } else {
                println("Такого элемента нет. Попробуйте снова.")
            }
        }
    }

    private fun inputInt(): Int {
        while (true) {
            val input = Scanner(System.`in`).nextLine()
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                println("Введите цифру.")
            }
        }
    }
}