#language: pt
#Author: davi.antunes.d.souza@accenture.com

@formulario
Funcionalidade:
  Como usuario
  Quero preencher os dados do produto
  Para validar o cadastro do produto enviado com sucesso

  @formulario
  Cenario: validar tela de produto

    Dado que eu esteja na pagina do produto "Enter Product Data"
    Quando preencho todos os campos obrigatorios do produto
    Entao vou para a pagina de selecao de precos