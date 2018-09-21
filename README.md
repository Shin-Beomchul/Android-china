# Android-china
Android 중국개발 샘플

# WeChat 페이 SDK 현지화(한국)
**Just Build & Run 세팅**
1. libs제거.

2. 그래들 의존성 추가 implementation 'com.tencent.mm.opensdk:wechat-sdk-android-with-mta:5.1.6'

3. 빌드 그래들 3.0.0으로 변경 

4.멀티덱스 Fix multiDexEnabled true , multiDexEnabled true

5. 실행 후 결제 테스트 : 네트워크 작업을 UI스레드에서 하고 있는 샘플??.. -> 수정

6. wechat - 한글화

7. OldSample 개선


**언어번역 Strings 중국어 -> En변경** 

# Push
 Baidu http://push.baidu.com/console/app
 
 sbc0830 / !t
 
 Android Client : http://push.baidu.com/doc/android/api
  
 IOS Client : http://push.baidu.com/doc/ios/api
  
 Server(java) : http://push.baidu.com/doc/java/api
  
  
  
