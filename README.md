# Calculadora de Propinas

## Conceptos

Kotlin básico, UI simple, eventos

## Objetivo

Crear una aplicación que calcule propinas basándose en el total de la cuenta y el porcentaje de
propina seleccionado.

## Funcionalidades Requeridas

- [x] Campo de entrada para el monto total
- [x] Selector de porcentaje de propina (10%, 15%, 20%)
- [x] Mostrar el monto de la propina calculado
- [x] Mostrar el total final (cuenta + propina)
- [x] Botón para limpiar los campos

## Estructura de Archivos

```
app/src/main/java/com/tuapp/calculadorapropinas/
├── MainActivity.kt
└── utils/
└── CalculadoraUtils.kt
app/src/main/res/layout/
└── activity_main.xml
```

## Retos Adicionales

- [x] Validar que el monto ingresado sea válido
- [x] Permitir propinas personalizadas
- [x] Guardar la preferencia de porcentaje usando SharedPreferences
- [ ] Agregar animaciones suaves

## Consideraciones personales

- Compatibilidad mínima: API 23 (Marshmallow, Android 6.0)
- Layout adicional para orientación horizontal
- `viewModel` para preservar los valores ante cambios de configuración de dispositivo
