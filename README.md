# rn-manage-wallpaper

this package allows you to access wallpaper tools from native apis

## Installation

```sh
yarn add rn-manage-wallpaper
```

## After install run this to link the packages.
```sh
yarn android
```

## permissions

this package needs the following permissions:

```xml
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

## Usage

WallpaperManager has one function called setWallpaper that receives 2 arguments, file uri and a flag that indicates whenever it will be set as lock screen or system screen, [FLAG_LOCK](https://developer.android.com/reference/android/app/WallpaperManager#FLAG_LOCK) and [FLAG_SYSTEM](https://developer.android.com/reference/android/app/WallpaperManager#FLAG_SYSTEM) for reference, you can get their values using the getConstants function.

## Example

in this example i use RNFetchBlob to donwload a web image and use the cache file path to define the wallpaper

```js
import WallpaperManager from 'rn-manage-wallpaper';

// ...

const FLAG_CONSTANTS = WallpaperManager.getConstants();
RNFetchBlob.config({
      // add this option that makes response data to be stored as a file,
      fileCache: true,
    })
      .fetch('GET', image.url, {
        //some headers ..
      })
      .then(res => {
        try {
          WallpaperManager.setWallpaper(`${res.path()}`, FLAG_CONSTANTS.FLAG_SYSTEM);
        } catch (error) {
          console.log(error);
        }
      });
  ```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
