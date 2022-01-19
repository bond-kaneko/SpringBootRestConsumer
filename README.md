# SprngBootRestConsumer

REST APIを利用するSpringBootアプリケーションのサンプルです。

APIサーバーのモックをたてて動作検証することにしました。

SpringBootアプリケーションを実行すると、`SpringBootRestConsumerApplication`の`run()`が実行されます。
その際に`localhost:3000/quotes` へGETリクエストを送信します。レスポンスを受け取り、`Quote.java`に変換してlogに出力します。

## JSON Server

コードを書かずにREST APIのモックを作成できるツールです。

npm installして

`$ npm install -g json-server`

`db.json` ファイルを作成して

```
{
  "posts": [
    { "id": 1, "title": "json-server", "author": "typicode" }
  ],
  "comments": [
    { "id": 1, "body": "some comment", "postId": 1 }
  ],
  "profile": { "name": "typicode" }
}
```

`db.json`を置いているディレクトリで下記コマンドを実行すれば起動します。

`$ json-server --watch db.json`

```
$ curl localhost:3000/posts
[
  {
    "id": 1,
    "title": "json-server",
    "author": "typicode"
  }
]
```
