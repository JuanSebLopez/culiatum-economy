# Culiatum Economy

Mod base para Fabric 1.21.11 que agrega la moneda `Culiatum Coin` como item fisico.

## Incluye

- Item registrado: `culiatum_coin`
- Nuevas denominaciones: `copper_coin`, `silver_coin`, `gold_coin`, `culiatum_coin`
- Nombre localizado en ingles y espanol
- Modelo y textura inicial
- Base simple para intercambio con NPCs
- Config para habilitar o deshabilitar crafteos

## Probar

```powershell
.\gradlew.bat runClient
```

Luego puedes darte monedas con:

```mcfunction
/give @p culiatum_economy:culiatum_coin 16
```

## Versionado

- Usa `mod_version` en [gradle.properties](C:\Users\EQUIPO\Desktop\mods\Fabric\Culiatum Economy\gradle.properties)
- Actualiza [CHANGELOG.md](C:\Users\EQUIPO\Desktop\mods\Fabric\Culiatum Economy\CHANGELOG.md) antes de publicar

## Modrinth

Publicacion manual:

- Ejecuta `.\gradlew.bat build`
- Sube [culiatum-economy-1.1.0.jar](C:\Users\EQUIPO\Desktop\mods\Fabric\Culiatum Economy\build\libs\culiatum-economy-1.1.0.jar) a Modrinth

Publicacion automatica:

- Pon tu `modrinth_project_id` en [gradle.properties](C:\Users\EQUIPO\Desktop\mods\Fabric\Culiatum Economy\gradle.properties)
- Define `MODRINTH_TOKEN` en tu entorno
- Ejecuta `.\gradlew.bat modrinth`

Para revisar la metadata actual:

```powershell
.\gradlew.bat printReleaseInfo
```
