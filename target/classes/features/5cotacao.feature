#language: pt
#Author: davi.antunes.d.souza@accenture.com

@formulario
Funcionalidade:
  Como usuario
  Quero preencher os dados de cotacao
  Para validar a cotacao de precos enviado com sucesso

  @formulario
  Cenario: validar tela de cotacao de precos

    Dado que eu esteja na pagina de cotacao de precos "Send Quote"
    Quando preencho todos os campos obrigatorios da cotacao
    Entao envio a cotacao verificando a mensagem "Sending e-mail success!"