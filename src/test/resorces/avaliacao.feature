# language: pt
Funcionalidade: Cálculo da média e situação do aluno
  Como professor
  Quero calcular a média de duas notas
  Para saber a situação de aluno

#Aprovação
  Cenário: Aluno aprovado
    Dado que o aluno tirou as notas 8 e 6
    Quando eu calculo a média e verifico a situação
    Então a média deve ser 7
    E a situação deve ser "APROVADO"

# Recuperação
  Cenário: Aluno de recuperação
    Dado que o aluno tirou as notas 6 e 6
    Quando eu calculo a média e verifico a situação
    Então a média deve ser 6
    E a situação deve ser "RECUPERAÇÃO"

#Erro de nota inválida
  Cenário: Nota inválida
    Dado que o aluno tirou as notas 11 e 8
    Quando eu calculo a média e verifico a situação
    Então deve ocorrer o erro "NOTA INVÁLIDA: 11.0"