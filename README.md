# Learn SPRING BOOT 

## Notions de base
1. Inversion de controle (IoC)
   
   Elle permet de gérer les dependences d'une classe en enlévant la liaison forte d'une classe A dependant d'une classe B. Elle permet que lors de la creation de la classe A on se soucis pas de sa dependance à la classe B.
   On a deux method:
   - BeanFactory
   - ApplicationContext (Hérite de BeanFactory)

   Avec BeanFactory on a deux posibilité:
   - Utiliser le system de fichier de son OS
   - utiliser le ClassPathResource

    Pour Utiliser les dependances on peut utiliser
    - `@Autowired` (Conseiller)

        exemple
        ```
        class ClassA {
            @autowired
            private ClassB classB;
        }
        ```
    - Le constructeurs, les setteurs
  
        exemple
        ```
        class ClassA {
            private ClassB classB;

            ClassA(ClassB classB) {
                this.classB = classB;
            }
        }
        ```


## Question a poser
- ESt-ce qu'il existe des classes générique en Spring pour les implementations de base
- 