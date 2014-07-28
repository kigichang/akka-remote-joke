# Akka Romote Joke
用 __吃飯睡覺打東東__ 的企鵝笑話，來 demo Akka Romote 的功能。程式會將 __企鵝__ 送到~~南~~北極來執行。

## 檔案說明

* Message.scala
  
  定義傳送的 message
  
* Penguin.scala
  
  企鵝物件
  
* Reporter.scala

  記者物件，如果有傳入 Path Array, 則用查詢的方式取得 Actor，否則產生新的
  
* Lookup*.scala

  Lookup 模式程式
  
* Deploy*.scala

  Deployment 模式程式
  


  