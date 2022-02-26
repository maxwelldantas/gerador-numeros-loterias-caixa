import java.io.File
import java.time.LocalDateTime

class MegaSena {

    val numeros = (1..60)
    val numerosQueSeraoSorteadosMegaSena: ArrayList<Int> = ArrayList()

    companion object {
        fun jogosMegaSena(quantidadeJogos: Int) {
            val jogosParaGravar = StringBuilder()

            for (j in 1 until (quantidadeJogos + 1)) {
                val megaSena = MegaSena()
                val numerosQueSeraoSorteadosMegaSena = megaSena.numerosQueSeraoSorteadosMegaSena
                while (numerosQueSeraoSorteadosMegaSena.size != 6) {
                    val x = megaSena.numeros.random().toString().toInt()
                    if (!numerosQueSeraoSorteadosMegaSena.contains(x)) {
                        numerosQueSeraoSorteadosMegaSena.add(x)
                    }
                }

                // Ordenando números na lista
                numerosQueSeraoSorteadosMegaSena.sort()

                val sb = StringBuilder()
                for (x in 0 until numerosQueSeraoSorteadosMegaSena.size) {
                    val umAnove = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    if (umAnove.contains(numerosQueSeraoSorteadosMegaSena[x])) {
                        sb.append("0${numerosQueSeraoSorteadosMegaSena[x]}")
                        if (x != numerosQueSeraoSorteadosMegaSena.size - 1) {
                            sb.append(" ")
                        }
                    } else {
                        sb.append("${numerosQueSeraoSorteadosMegaSena[x]}")
                        if (x != numerosQueSeraoSorteadosMegaSena.size - 1) {
                            sb.append(" ")
                        }
                    }
                }
                print("Jogo número $j: ")
                println(sb)
                jogosParaGravar.append("Jogo número $j: ".plus(sb.append("\n")))
            }

            gravarJogos(jogosParaGravar)

            val valorJogos = 4.50F * quantidadeJogos
            println("Custo para realizar este(s) jogo(s): R$ $valorJogos")

            if (valorJogos >= 30.0) {
                println("Com este custo estes jogos podem ser apostados na Loterias CAIXA online")
            } else {
                println("Com este custo este(s) jogo(s) não pode(m) ser apostado(s) na Loterias CAIXA online")
            }
        }

        private fun gravarJogos(sb: StringBuilder) {
            sb.setLength(sb.length - 1)
            val dia = LocalDateTime.now().dayOfMonth
            val mes = LocalDateTime.now().monthValue
            val ano = LocalDateTime.now().year
            val hora = LocalDateTime.now().hour
            val minuto = LocalDateTime.now().minute
            val segundo = LocalDateTime.now().second
            val dataHorario = "$dia-$mes-$ano-${hora}h${minuto}m${segundo}s"
            File("Apostas-Mega-Sena-$dataHorario.txt").writeText(sb.toString())
        }
    }
}