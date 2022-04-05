# Android-china
Android & IOS 중국개발 Log

# WeChat 페이 SDK 현지화(한국)
Weixin Develop Home : https://open.weixin.qq.com/
가입은 간단하지만 개발자 인증인 상당히 까다로운 편

**Just Build & Run 세팅**
```
1. libs제거.
2. 그래들 의존성 추가 implementation 'com.tencent.mm.opensdk:wechat-sdk-android-with-mta:5.1.6'
3. 빌드 그래들 3.0.0으로 변경 
4.멀티덱스 Fix multiDexEnabled true , multiDexEnabled true
5. 실행 후 결제 테스트 : 네트워크 작업을 UI스레드에서 하고 있는 샘플??.. -> 수정
6. wechat - 한글화
7. OldSample 개선
```

**언어번역 Strings 중국어 -> En변경** 

# Push
```
 Baidu http://push.baidu.com/console/app
 Android Client : http://push.baidu.com/doc/android/api
 IOS Client : http://push.baidu.com/doc/ios/api
 Server(java) : http://push.baidu.com/doc/java/api
 ```
  
  
# 마켓 업로드(Tencent, 360, Baidu)
```
 기업계정 생성 시 필수조건 : 경영성 허가증
 업로드 필수조건 : sw저작권증명서, 전자 SW저작권증명서
 특수앱같은 경우 굉장히 까다로워 질 수 있음. 각종 증명서들 필요.

 Tencent : https://user.open.qq.com/ -> 응용프로그램 개방형 플랫폼
 기업계정 Try : 3450439503
 개인계정 Try : sbc0830g@g***
 ```
 
 
 # 팁
  특별한 이유가 없다면 안드로이드 서비스는 나중에 진입 할것. IOS 먼저 진입.
   https://www.mobvista.com/kr/blog/중국-게임시장-진출의-성공-노하우/
 
   **weChat의 공식계정 혹은 미니프로그램 이라고 불리는 서비스가 모바일 스토어 시장을 빠르게 잠식하고 있음.**
   2018년 기준 향후 정말로 위챗 앱이 플랫폼이 될 수도 있음 
   https://user.open.qq.com/ 여기서 위챗 플랫폼이 바로 이 미니 프로그램, 공식계정 이라고 불림.
   
