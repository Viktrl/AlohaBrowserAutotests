1. Системные требования:
   - Node.js
   - npm
   - macOS 11.0 или выше
   - Xcode 13.0 или выше
   - в терминале выполнить sudo xcode-select -s /Applications/Xcode.app/Contents/Developer
   - Дать доступ Xcode Helper к Универсальному доступу в настройках системы
   - в терминале выполнить automationmodetool enable-automationmode-without-authentication
   - (https://appium.io/docs/en/latest/quickstart/requirements/
   - https://github.com/appium/appium-mac2-driver)
2. Установить appium на машину:
   - npm install -g appium
3. Установить appium-mac2-driver:
   - npm install -g appium-mac2-driver
4. Запустить Appium:
   - appium
5. Запустить тесты