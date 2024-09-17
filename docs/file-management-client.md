# File Management Client
`FileManagementClient` client is linked to a **REST API** that is part of the messaging product. It allows uploading and downloading file attachments used for messaging capabilities.

### API Endpoint
This client is connected with https://api.expediagroup.com/supply-lodging/v1/files endpoint by default.

You can refer to the [configuration]() document to explore the full configuration options.

### Initialize the Client
```java
ExpediaGroupClientConfiguration config = ExpediaGroupClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .build();

FileManagementClient fileManagementClient = new FileManagementClient(config);
```

## Available Operations

<details>
   <summary>download</summary>
<br />

**Summary:** Download attachments from a specific message resource.

**Example:**
```java
try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("image.png")))) {
    var downloadedAttachment = client.download("f97e884e-6caf-4bee-8b83-32a7cb96daa8", "messageId", "63363feb-2370-4cca-8b85-232597ff7438");
    bos.write(downloadedAttachment);
} catch (IOException e) {
    e.printStackTrace();
}
```
</details>

<hr />

<details>
   <summary>upload</summary>

<br />

**Summary:** used to upload file to a message resource and get identifier associated to it.

**Example:**
```java
File file = new File("image.png");
var response = client.upload(file, "messageThreadId", "5b3423da-af09-485a-9490-95b4452fbca0");
System.out.println(response);
```
</details>
