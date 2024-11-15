package com.example.appseguranadainformacao.core

import com.example.appseguranadainformacao.models.Question

class Constants {
    val quizQuestions = listOf(
        Question(
            "O que é phishing?",
            listOf("Ataque de engenharia social", "Vírus de computador", "Firewall", "Protocolo de segurança"),
            0 // Resposta correta: "Ataque de engenharia social"
        ),
        Question(
            "Qual é a maneira mais segura de criar senhas?",
            listOf("Usar apenas números", "Usar uma combinação de letras, números e símbolos", "Usar senhas fáceis de lembrar", "Reutilizar senhas antigas"),
            1 // Resposta correta: "Usar uma combinação de letras, números e símbolos"
        ),
        Question(
            "O que é um firewall?",
            listOf("Um tipo de malware", "Um software que previne acessos não autorizados", "Um programa de backup", "Uma senha segura"),
            1 // Resposta correta: "Um software que previne acessos não autorizados"
        ),
        Question(
            "Qual é a função da criptografia?",
            listOf("Proteger dados tornando-os ilegíveis para usuários não autorizados", "Permitir acessos remotos", "Excluir arquivos indesejados", "Detectar ameaças de vírus"),
            0 // Resposta correta: "Proteger dados tornando-os ilegíveis para usuários não autorizados"
        ),
        Question(
            "O que significa o conceito de 'autenticidade' na segurança da informação?",
            listOf("Confirma a veracidade de uma entidade ou pessoa", "Permite que um usuário acesse qualquer sistema", "Impede o uso de senhas", "Garante a criptografia dos dados"),
            0 // Resposta correta: "Confirma a veracidade de uma entidade ou pessoa"
        ),
        Question(
            "Qual das seguintes é uma boa prática de segurança da informação?",
            listOf("Compartilhar senhas com colegas de trabalho", "Usar redes Wi-Fi públicas sem VPN", "Manter os sistemas e softwares atualizados", "Desativar atualizações automáticas"),
            2 // Resposta correta: "Manter os sistemas e softwares atualizados"
        ),
        Question(
            "Qual é o objetivo principal de um ataque de ransomware?",
            listOf("Roubar dados de cartão de crédito", "Bloquear o acesso a dados ou sistemas até que um resgate seja pago", "Monitorar atividades de navegação", "Excluir permanentemente os dados da empresa"),
            1 // Resposta correta: "Bloquear o acesso a dados ou sistemas até que um resgate seja pago"
        ),
        Question(
            "O que você deve fazer ao receber um e-mail suspeito?",
            listOf("Abrir o e-mail e clicar nos links para verificar", "Deletar imediatamente e nunca clicar em links suspeitos", "Encaminhar o e-mail para outros para confirmação", "Responder solicitando mais informações"),
            1 // Resposta correta: "Deletar imediatamente e nunca clicar em links suspeitos"
        ),
        Question(
            "O que significa 'engenharia social'?",
            listOf("Técnica usada para influenciar pessoas a revelarem informações confidenciais", "Um tipo de malware", "Um firewall de alta segurança", "Um tipo de criptografia avançada"),
            0 // Resposta correta: "Técnica usada para influenciar pessoas a revelarem informações confidenciais"
        ),
        Question(
            "Como uma VPN (Rede Privada Virtual) pode ajudar a proteger sua privacidade?",
            listOf("Aumenta a velocidade da internet", "Permite navegação anônima e criptografa o tráfego de dados", "Desativa firewalls", "Remove vírus do computador"),
            1 // Resposta correta: "Permite navegação anônima e criptografa o tráfego de dados"
        )
    )
    val securityInfo: Map<String, String> = mapOf(
        "SEGURANÇA DA INFORMAÇÃO" to """
            A segurança da informação é o termo que se refere à proteção de informações e sistemas de informação contra acesso não autorizado, uso, divulgação, interrupção, modificação ou destruição, com o objetivo de garantir que as informações permaneçam confidenciais, confiáveis e acessíveis (Docusign, 2007). 
            
            As práticas e princípios da segurança da informação se baseiam nos cinco seguintes pilares:
            
            1. Confidencialidade: envolve medidas para garantir que as informações sejam mantidas em sigilo. Apenas usuários autorizados devem acessar dados que sejam de sua propriedade ou responsabilidade. Caso pessoas não autorizadas acessem esses dados, há um comprometimento da confiabilidade, com prejuízos como vazamentos, roubos e danos à reputação da empresa.
            2. Integridade: garante que não ocorram alterações nos arquivos, sejam eles internos ou externos. A partir desse pilar, é implementada a licença que cada usuário terá.
            3. Disponibilidade: assegura que os usuários responsáveis pelos dados possam acessar as informações sempre que necessário. Isso é crucial, pois algumas empresas podem parar seus processos devido à falta de acesso aos dados.
            4. Irretratabilidade: garante que uma entidade ou pessoa não possa negar a autoria de informações fornecidas. Isso é especialmente relevante em casos de assinaturas digitais e certificados.
            5. Autenticidade: outro conceito importante que inclui o não repúdio, que impede que as partes envolvidas neguem a autoria de transações ou alterações; autenticidade, que confirma que os usuários ou dispositivos são verdadeiros, garantindo que todas as ações do sistema possam ser atribuídas a um indivíduo (Docusign, 2007).
        """.trimIndent(),

        "BOAS PRÁTICAS DE SEGURANÇA DA INFORMAÇÃO" to """
            A segurança da informação constitui um conjunto de conceitos voltados para a proteção dos dados de usuários e instituições. É essencial adotar as devidas precauções para garantir sua integridade. Manter os softwares atualizados e autênticos é fundamental, visto que os desenvolvedores estão constantemente aprimorando suas medidas de segurança para evitar ataques cibernéticos (Mclaughlin; David; Gogan; Janis; 2018).
            
            A gestão de incidentes desempenha um papel crucial na preservação da integridade dos dados, além de assegurar a conformidade com as regulamentações vigentes. É imprescindível antecipar possíveis ameaças e adotar estratégias para preveni-las (Mclaughlin; David; Gogan; Janis; 2018).
            
            O controle de acesso requer a implementação de políticas que restrinjam o acesso às informações apenas a usuários autorizados. Muitas empresas optam por criar grupos de permissão, divididos de acordo com as responsabilidades atribuídas na organização (Mclaughlin; David; Gogan; Janis; 2018).
            
            A realização regular de backups é crucial, uma vez que as informações podem ser corrompidas ou violadas. Manter backups periódicos garante que tanto indivíduos quanto instituições tenham acesso aos dados necessários, mitigando as consequências de imprevistos. Os backups são uma prática indispensável no dia a dia, pois, apesar dos avanços tecnológicos, ainda é comum a perda de dados devido a erros humanos ou falhas computacionais (Mclaughlin; David; Gogan; Janis; 2018).
            
            Investir em software de segurança de qualidade é fundamental para proteger os dados contra ameaças. O mercado oferece diversas ferramentas, como antivírus e firewall, que auxiliam na prevenção de infecções e ataques. Esse investimento não só protege equipamentos e arquivos, mas também evita prejuízos decorrentes de violações de segurança (Docusign, 2022).
            
            Além disso, é importante manter os softwares sempre atualizados, pois as atualizações frequentes incluem correções de vulnerabilidades que podem ser exploradas por hackers. Dessa forma, a combinação de backups regulares e software de segurança eficiente garante uma proteção mais completa dos dados da empresa (Docusign, 2022).
        """.trimIndent(),

        "IMPORTÂNCIA DA SEGURANÇA DA INFORMAÇÃO" to """
            A proteção da informação corporativa e pessoal é essencial para manter a confiança e a integridade das atividades econômicas e sociais na era da informação. Para as empresas, proteger os ativos de informações contra ameaças cibernéticas reduz riscos operacionais e os prejuízos financeiros resultantes de violações de dados. Além disso, a conformidade regulatória depende da segurança da informação para garantir que as empresas cumpram as leis e regulamentos sobre proteção de dados e privacidade (Silva; Ranghetti; Milnitsky, 2007).
            
            A confiança dos clientes, que geralmente é reforçada pela crença de que seus dados estão seguros, pode ser gravemente abalada por incidentes de segurança, que podem prejudicar a reputação e a viabilidade de uma organização. Portanto, a implementação de estratégias de segurança da informação não apenas protege contra ataques internos e externos, mas também cria uma cultura organizacional que valoriza a segurança como um componente vital para a sustentabilidade e a confiança da empresa no mundo digital (Silva; Ranghetti; Milnitsky, 2007).
            
            Hoje, a segurança da informação está no centro das estratégias de TI de todas as organizações. É fundamental proteger dados pessoais e corporativos ao mesmo tempo. A evolução da segurança da informação é impulsionada pelos avanços tecnológicos e pela natureza inesgotável das ameaças cibernéticas. Isso torna ainda mais importante adaptar e desenvolver contínuas medidas de segurança (Silva; Ranghetti; Milnitsky, 2007).
            
            Desde os primórdios da era computacional, os riscos estão presentes. No entanto, na sociedade vigente, as consequências são maiores, o que acaba gerando a necessidade de inovação diária (Docusign, 2022).
        """.trimIndent()
    )

    val dailyTips = listOf(
        "Mantenha seu software sempre atualizado para evitar vulnerabilidades conhecidas.",
        "Use senhas fortes e diferentes para cada serviço, evitando reutilizações.",
        "Habilite a autenticação em duas etapas para aumentar a segurança de suas contas.",
        "Nunca compartilhe suas senhas, mesmo com pessoas de confiança.",
        "Evite usar redes Wi-Fi públicas sem uma VPN para proteger seus dados.",
        "Realize backups regulares de seus dados para evitar perdas em casos de ataques.",
        "Desconfie de e-mails e mensagens de remetentes desconhecidos que pedem informações pessoais.",
        "Utilize soluções de segurança como antivírus e firewalls para proteger seu dispositivo.",
        "Ao acessar sites, verifique se a URL começa com 'https://' para garantir uma conexão segura.",
        "Desconecte dispositivos de armazenamento externos de forma segura para evitar a corrupção de dados.",
        "Evite clicar em links de e-mails não solicitados, principalmente aqueles que pedem informações sensíveis.",
        "Desative o compartilhamento automático de informações em suas redes sociais para proteger sua privacidade.",
        "Ao trabalhar remotamente, use sempre uma rede VPN para acessar recursos internos da empresa.",
        "Limpe regularmente o histórico e os cookies do seu navegador para proteger sua privacidade online.",
        "Configure permissões adequadas nos arquivos compartilhados para garantir que apenas pessoas autorizadas tenham acesso."
    )
}
