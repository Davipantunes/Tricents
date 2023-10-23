#language: pt
#Author: davi.antunes.d.souza@accenture.com

@formulario
Funcionalidade:
  Como usuario
  Quero preencher os dados obrigatorios do veiculo
  Para validar o cadastro do veiculo enviado com sucesso

  @formulario
  Cenario: validar tela de cadastro do veiculo

    Dado que eu esteja no site
    Quando preencho todos os campos obrigatorios
    Entao vou para a pagina "Enter Insurant Data"