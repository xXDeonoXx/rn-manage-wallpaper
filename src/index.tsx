import { NativeModules } from 'react-native';

type WallpaperManagerType = {
  multiply(a: number, b: number): Promise<number>;
};

const { WallpaperManager } = NativeModules;

export default WallpaperManager as WallpaperManagerType;
