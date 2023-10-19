package qwer.runner.betfootball.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import qwer.runner.betfootball.R
import qwer.runner.betfootball.model.TeamModel

class ListViewModel(application: Application) : AndroidViewModel(application) {
    val teamList = listOf(
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/1200px-Flag_of_Brazil.svg.png",
            application.getString(R.string.brazil),
            listOf(
                "Neymar",
                "Casemiro",
                "Roberto Firmino",
                "Marquinhos",
                "Alisson Becker",
                "Philippe Coutinho",
                "Richarlison",
                "Fabinho",
                "Gabriel Jesus",
                "Thiago Silva"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/1200px-Flag_of_Germany.svg.png",
            application.getString(R.string.germany),
            listOf(
                "Manuel Neuer",
                "Toni Kroos",
                "Joshua Kimmich",
                "Leroy Sané",
                "Serge Gnabry",
                "Kai Havertz",
                "Ilkay Gündogan",
                "Niklas Süle",
                "Timo Werner",
                "Matthias Ginter"
            )

        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Flag_of_Italy.svg/800px-Flag_of_Italy.svg.png",
            application.getString(R.string.italy),
            listOf(
                "Ciro Immobile",
                "Lorenzo Insigne",
                "Giorgio Chiellini",
                "Leonardo Bonucci",
                "Marco Verratti",
                "Federico Chiesa",
                "Jorginho",
                "Nicolo Barella",
                "Gianluigi Donnarumma",
                "Alessandro Florenzi"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/1200px-Flag_of_Argentina.svg.png",
            application.getString(R.string.argentina),
            listOf(
                "Lionel Messi",
                "Paulo Dybala",
                "Sergio Agüero",
                "Giovani Lo Celso",
                "Rodrigo De Paul",
                "Lautaro Martínez",
                "Nicolás Otamendi",
                "Marcos Acuña",
                "Emiliano Martínez",
                "Ángel Di María"
            )
        ),
        TeamModel(
            "https://images.jifo.co/45290795_1569262755633.png",
            application.getString(R.string.france),
            listOf(
                "Kylian Mbappé",
                "Antoine Griezmann",
                "N'Golo Kanté",
                "Paul Pogba",
                "Karim Benzema",
                "Raphaël Varane",
                "Hugo Lloris",
                "Olivier Giroud",
                "Benjamin Pavard",
                "Lucas Hernández"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/36/4336-050-056AC114/Flag-Spain.jpg",
            application.getString(R.string.spain),
            listOf(
                "Sergio Ramos",
                "Sergio Busquets",
                "Thiago Alcântara",
                "Álvaro Morata",
                "Koke",
                "Ferran Torres",
                "Dani Olmo",
                "Pedri",
                "Gerard Moreno",
                "Jordi Alba"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Flag_of_the_Netherlands.svg/383px-Flag_of_the_Netherlands.svg.png",
            application.getString(R.string.netherlands),
            listOf(
                "Virgil van Dijk",
                "Frenkie de Jong",
                "Memphis Depay",
                "Georginio Wijnaldum",
                "Matthijs de Ligt",
                "Donny van de Beek",
                "Steven Berghuis",
                "Denzel Dumfries",
                "Luuk de Jong",
                "Ryan Gravenberch"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/44/344-004-494CC2E8/Flag-England.jpg",
            application.getString(R.string.england),
            listOf(
                "Harry Kane",
                "Raheem Sterling",
                "Jordan Henderson",
                "Jack Grealish",
                "Marcus Rashford",
                "Phil Foden",
                "Ben Chilwell",
                "John Stones",
                "Declan Rice",
                "Bukayo Saka"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/74/4874-004-50846A53/Flag-Uruguay.jpg",
            application.getString(R.string.uruguay),
            listOf(
                "Luis Suárez",
                "Edinson Cavani",
                "Diego Godín",
                "Federico Valverde",
                "Nahitan Nández",
                "Lucas Torreira",
                "José María Giménez",
                "Rodrigo Bentancur",
                "Maxi Gómez",
                "Gastón Pereiro"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Portugal.svg/800px-Flag_of_Portugal.svg.png",
            application.getString(R.string.portugal),
            listOf(
                "Cristiano Ronaldo",
                "Bruno Fernandes",
                "Diogo Jota",
                "Bernardo Silva",
                "João Cancelo",
                "Ruben Dias",
                "Rúben Neves",
                "Raphaël Guerreiro",
                "André Silva",
                "Danilo Pereira"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/1182px-Flag_of_Belgium.svg.png",
            application.getString(R.string.belgium),
            listOf(
                "Kevin De Bruyne",
                "Romelu Lukaku",
                "Eden Hazard",
                "Thibaut Courtois",
                "Dries Mertens",
                "Youri Tielemans",
                "Axel Witsel",
                "Toby Alderweireld",
                "Thomas Meunier",
                "Yannick Carrasco"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/en/thumb/4/4c/Flag_of_Sweden.svg/1200px-Flag_of_Sweden.svg.png",
            application.getString(R.string.sweden),
            listOf(
                "Zlatan Ibrahimović",
                "Emil Forsberg",
                "Victor Lindelöf",
                "Sebastian Larsson",
                "Dejan Kulusevski",
                "Robin Olsen",
                "Albin Ekdal",
                "Mikael Lustig",
                "Kristoffer Olsson",
                "Alexander Isak"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/85/7485-004-00B07230/Flag-Chile.jpg",
            application.getString(R.string.chile),
            listOf(
                "Alexis Sánchez",
                "Arturo Vidal",
                "Claudio Bravo",
                "Gary Medel",
                "Eduardo Vargas",
                "Charles Aránguiz",
                "Jean Beausejour",
                "Mauricio Isla",
                "Erick Pulgar",
                "Gabriel Arias"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/73/2573-004-29818847/Flag-Mexico.jpg",
            application.getString(R.string.mexico),
            listOf(
                "Hirving Lozano",
                "Raúl Jiménez",
                "Javier Hernández",
                "Andrés Guardado",
                "Héctor Herrera",
                "Carlos Vela",
                "Memo Ochoa",
                "Diego Lainez",
                "Néstor Araújo",
                "Edson Álvarez"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/07/8007-004-8CF0B1A9/Flag-Denmark.jpg",
            application.getString(R.string.denmark),
            listOf(
                "Christian Eriksen",
                "Kasper Schmeichel",
                "Pierre-Emile Højbjerg",
                "Yussuf Poulsen",
                "Thomas Delaney",
                "Andreas Christensen",
                "Martin Braithwaite",
                "Simon Kjaer",
                "Jonas Wind",
                "Daniel Wass"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/43/4543-004-C0D5C6F4/Flag-Switzerland.jpg",
            application.getString(R.string.switzerland),
            listOf(
                "Granit Xhaka",
                "Xherdan Shaqiri",
                "Haris Seferovic",
                "Ricardo Rodríguez",
                "Manuel Akanji",
                "Denis Zakaria",
                "Yann Sommer",
                "Breel Embolo",
                "Fabian Schär",
                "Steven Zuber"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Colombia.svg/383px-Flag_of_Colombia.svg.png",
            application.getString(R.string.colombia),
            listOf(
                "James Rodríguez",
                "Radamel Falcao",
                "Juan Cuadrado",
                "Davinson Sánchez",
                "Wilmar Barrios",
                "Luis Muriel",
                "Yerry Mina",
                "Alfredo Morelos",
                "Mateus Uribe",
                "Jefferson Lerma"
            )
        ),
        TeamModel(
            "https://cdn.britannica.com/48/3448-004-33B5D198/Flag-Peru.jpg",
            application.getString(R.string.peru),
            listOf(
                "Paolo Guerrero",
                "Christian Cueva",
                "Jefferson Farfán",
                "Renato Tapia",
                "André Carrillo",
                "Luis Advíncula",
                "Pedro Gallese",
                "Carlos Zambrano",
                "Edison Flores",
                "Yoshimar Yotún"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Flag_of_Austria.svg/2560px-Flag_of_Austria.svg.png",
            application.getString(R.string.austria),
            listOf(
                "David Alaba",
                "Marko Arnautovic",
                "Marcel Sabitzer",
                "Julian Baumgartlinger",
                "Xaver Schlager",
                "Stefan Lainer",
                "Konrad Laimer",
                "Alessandro Schöpf",
                "Martin Hinteregger",
                "Christopher Trimmel"
            )
        ),
        TeamModel(
            "https://upload.wikimedia.org/wikipedia/en/thumb/1/12/Flag_of_Poland.svg/1200px-Flag_of_Poland.svg.png",
            application.getString(R.string.poland),
            listOf(
                "Robert Lewandowski",
                "Arkadiusz Milik",
                "Piotr Zielinski",
                "Kamil Glik",
                "Grzegorz Krychowiak",
                "Wojciech Szczesny",
                "Krzysztof Piatek",
                "Karol Linetty",
                "Jan Bednarek",
                "Bartosz Bereszynski"
            )
        )
    )
    val listOfStyle = listOf(
        application.getString(R.string.attacking_against_a_zone_defence),
        application.getString(R.string.positional_attack),
        application.getString(R.string.counter_attack_fast_break),
        application.getString(R.string.pressing_defence),
        application.getString(R.string.mixed_defence),
        application.getString(R.string.zone_defence),
        application.getString(R.string.defence_against_the_ball_carrier)
    )
}
