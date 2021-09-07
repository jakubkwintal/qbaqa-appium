Feature: Does Google Translator translate correctly?

  Scenario Outline: Translation
    Given languages <fromLanguage> and <toLanguage>
    When I type <text>
    Then I should receive <translation>
    Examples:
      | fromLanguage | toLanguage | text                   | translation     |
      | "English"    | "French"   | "Hello"                | "Bonjour"       |
      | "English"    | "Polish"   | "yes"                  | "tak"           |
      | "French"     | "Spanish"  | "Quelle heure est-il?" | "¿Qué hora es?" |
