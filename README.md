# TrucoScoreBoard

Placar eletrônico para jogo de Truco desenvolvido para Android.

## Descrição

Aplicativo simples que permite controlar a pontuação de duas equipes em uma partida de Truco. O app detecta automaticamente situações especiais do jogo, como a **mão de 11** e o **fim de partida**, exibindo alertas para os jogadores.

## Funcionalidades

- Placar individual para Equipe A e Equipe B
- Botão **+1** para adicionar 1 ponto à equipe
- Botão **+3** para adicionar 3 pontos à equipe (suporta mão de 6 e mão de 9)
- Aviso automático quando uma equipe entra na **mão de 11**
- Aviso de **fim de jogo** com exibição do vencedor ao atingir 12 pontos
- Botão de **reiniciar** para zerar o placar e começar nova partida

## Especificações Técnicas

| Item | Versão |
|---|---|
| Android Studio | Panda 1 |
| Kotlin | 2.2.0 |
| Gradle | 9.2.1 |
| AGP | 9.0.1 |
| API mínima | 26 (Android 8.0 Oreo) |

## Pacote

`br.edu.ifsp.scl.sc3037291.trucoscoreboard`

## Estrutura do Projeto

```
app/
├── src/
│   └── main/
│       ├── java/br/edu/ifsp/scl/sc3037291/trucoscoreboard/
│       │   └── MainActivity.kt
│       └── res/
│           ├── layout/
│           │   └── activity_main.xml
│           └── values/
│               ├── strings.xml
│               └── themes.xml
```

## Como executar

1. Clone o repositório
2. Abra o projeto no **Android Studio Panda 1**
3. Aguarde a sincronização do Gradle
4. Execute em um emulador ou dispositivo físico com Android 8.0 ou superior
