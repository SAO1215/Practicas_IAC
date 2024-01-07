# Práctica 3: Aprendizaje Automático

El propósito de esta práctica es que alumno desarrolle un modelo de predición usando algoritmos de aprendizaje automatico y el tratado de datos pertinente.

## Problema a resolver: Predecir el riesgo de hipertensión

Segun la secretaria de salud de México: "Se estima que en México más de 30 millones de personas viven con hipertensión arterial; es decir, una de cada cuatro tiene este padecimiento, y 46 por ciento lo desconoce."

## Explicacion del programa

Este proyecto utiliza varios modelos de machine learning para predecir el riesgo de hipertensión arterial en función de un conjunto de datos. Se implementa en Python y utiliza la biblioteca scikit-learn para la construcción y evaluación de modelos.

## Fuente de datos

El data set utilizado en esta entrega es [Hipertension Arterial Mexico Data Set](https://www.kaggle.com/datasets/frederickfelix/hipertensin-arterial-mxico), que fue creado utilizando tres conjuntos de datos provenientes de la página de gobierno llamada Encuesta Nacional de Salud y Nutricion (ENSANUT).

Contiene los siguientes atributos, son las características relevantes de los hechos, que nos van a permitir predecir un resultado:

|  Nombre de Columna                | Descripción                                                                                                                    |
|-----------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| Sexo                              | Indica el género del paciente (1 para masculino, 2 para femenino)                                                              |
| Edad                              | Representa la edad del paciente en años                                                                                        |
| Concentración de Hemoglobina      | Mide la concentración de hemoglobina en la sangre del paciente                                                                 |
| Temperatura Ambiente              | Registra la temperatura ambiente durante la medición                                                                           |
| Valor de Ácido Úrico              | Indica el nivel de ácido úrico en la sangre del paciente                                                                       |
| Valor de Albúmina                 | Representa la concentración de albúmina en la sangre                                                                           |
| Valor de Colesterol HDL           | Indica el nivel de colesterol de lipoproteínas de alta densidad (HDL)                                                          |
| Valor de Colesterol LDL           | Representa el nivel de colesterol de lipoproteínas de baja densidad (LDL)                                                      |
| Valor de Colesterol Total         | Indica el nivel total de colesterol en la sangre del paciente                                                                  |
| Valor de Creatinina               | Representa la concentración de creatinina en la sangre                                                                         |
| Resultado de Glucosa              | Indica el resultado de la medición del nivel de glucosa                                                                        |
| Valor de Insulina                 | Representa la concentración de insulina en la sangre                                                                           |
| Valor de Proteína C Reactiva      | Indica el nivel de proteína C reactiva, un marcador de inflamación                                                             |
| Valor de Triglicéridos            | Representa el nivel de triglicéridos en la sangre                                                                              |
| Resultado de Glucosa Promedio     | Indica el nivel promedio de glucosa                                                                                            |
| Valor de Hemoglobina Glucosilada  | Representa la concentración de hemoglobina glucosilada                                                                         |
| Valor de Ferritina                | Indica el nivel de ferritina, una proteína que almacena hierro                                                                 |
| Valor de Folato                   | Representa el nivel de folato, una vitamina B                                                                                  |
| Valor de Homocisteína             | Indica el nivel de homocisteína en la sangre                                                                                   |
| Valor de Transferrina             | Representa la concentración de transferrina, una proteína que transporta hierro                                                |
| Valor de Vitamina B12             | Indica el nivel de vitamina B12 en la sangre                                                                                   |
| Valor de Vitamina D               | Representa el nivel de vitamina D en la sangre                                                                                 |
| Peso                              | Representa el peso del paciente                                                                                                |
| Estatura                          | Indica la altura del paciente                                                                                                  |
| Medida de Cintura                 | Representa la circunferencia de la cintura del paciente                                                                        |
| Segunda Medición de Peso          | Representa una segunda medición de peso, si está disponible                                                                    |
| Segunda Medición de Estatura      | Representa una segunda medición de altura, si está disponible                                                                  |
| Distancia Rodilla-Talón           | Representa la distancia desde la rodilla hasta el talón                                                                        |
| Circunferencia de la Pantorrilla  | Indica la circunferencia de la pantorrilla                                                                                     |
| Segunda Medición de Cintura       | Representa una segunda medición de la circunferencia de la cintura, si está disponible                                         |
| Tensión Arterial                  |  Indica la presión arterial del paciente                                                                                       |
| Sueño en Horas                    | Representa el número de horas de sueño                                                                                         |
| Masa Corporal                     | Indica el índice de masa corporal (IMC) del paciente                                                                           |
| Actividad Total                   | Representa la actividad física total del paciente                                                                              |
| Riesgo de Hipertensión            | La variable objetivo, indica si el paciente está en riesgo de desarrollar hipertensión (1 para en riesgo, 0 para no en riesgo) |

Para esta practica, la variable a predecir (y) es el riesgo de hipertensión. La variable objetivo, indica si el paciente está en riesgo de desarrollar hipertensión (1 para en riesgo, 0 para no en riesgo).

## Implementación

Al ejecutar el código se lleva a cabo el entrenamiento de los modelos y posteriormente se utiliza con los datos de prueba, se muestra el puntaje de precisión calculado con la misma librería de scikit-learn de cada uno de los modelos. Ademas por cada modelo se muestra una matriz de confusión que nos permite visualizar el desempeño de los modelos.

### Modelos Implementados

* Random Forest
* Logistic Regression
* SVM
* K-Nearest Neighbors
* Gradient Boosting
* AdaBoost

Estos modelos se seleccionaron ya que forman parte de distintos métodos de aplicables a aprendizaje automatico como: _Linear Models_, _Ensemble methods_, _Support vector machines (SVMs)_, _Nearest Neighbors_ y _Decision Tree-Based models_.

## Tratado de los datos

Contamos con un dataset bien documentado y mantenido, sin embargo, hace falta realizar algunas modificaciones para asegurar el mejor desempeño de los algoritmos.

Primero eliminamos la columna con el folio debido a que es un identificador y no será utilizado para el análisis.

Despues dividimos el dataset en datos de entrenamiento (85%) y de prueba (15%).

Y utilizamos el escalador sklearn.preprocessing.MinMaxScaler para transformar las características escalándolas a un rango dado, por defecto (0,1).

## Resultados

El modelo de Gradient Boosting es el que obtiene el mayor puntaje de precisión con 0.9954198473282443, esta medida representa la proporción de predicciones correctas con respecto al total de predicciones realizadas por el modelo.

![resultados](result_images/Resultados.png)

Tambien podemos verlo representado en la matriz de confusión, esta herramienta grafica nos permite mostrar la comparación entre las predicciones del modelo y las clases reales del conjunto de datos.

![matrizGB](result_images/test_results_sample.png)

### Gradient Boosting Classifier

El Gradient Boosting es una técnica de conjunto (ensemble) que se utiliza para mejorar el rendimiento predictivo de los modelos de machine learning. El Gradient Boosting Classifier esta diseñado específicamente para problemas de clasificación.

### Ejecución y Requisitos desde Notebook en Google Colabs

Notebook: [Practica3.ipynb](https://drive.google.com/file/d/10P7sGUYnpBR1_ygT3UUYRy2HfJb68eyO/view?usp=sharing)

### Ejecución y Requisitos desde Python con terminal

Para instalar las dependencias, ejecute:

```bash
pip install pandas scikit-learn matplotlib
```

Y para correr el programa:

```bash
python Practica3.py
```

EJEMPLO DE EJECUCIÓN EN: [Practica3.ipynb](https://drive.google.com/file/d/10P7sGUYnpBR1_ygT3UUYRy2HfJb68eyO/view?usp=sharing)

#### Requisitos

* Python 3
* Pandas
* scikit-learn
* Matplotlib
