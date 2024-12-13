#language: pt
#Author: davi.antunes.d.souza@accenture.com

@formulario
Funcionalidade:
  Como usuario
  Quero preencher os dados de selecao de precos
  Para validar a selecao de precos enviado com sucesso

  @formulario
  Cenario: validar tela de selecao de precos

    Dado que eu esteja na pagina de selecao de precos "Select Price Option"
    Quando preencho todos os campos obrigatorios da selecao
    Entao vou para a pagina de envio de cotacao