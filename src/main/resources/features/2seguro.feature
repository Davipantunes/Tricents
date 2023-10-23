#language: pt
#Author: davi.antunes.d.souza@accenture.com

@formulario
Funcionalidade:
  Como usuario
  Quero preencher os dados do seguro
  Para validar o cadastro do seguro enviado com sucesso

  @formulario
  Cenario: validar tela de seguros

    Dado que eu esteja na pagina do seguro "Enter Insurant Data"
    Quando preencho todos os campos obrigatorios do seguro
    Entao vou para a pagina do produto