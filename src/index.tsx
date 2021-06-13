import { NativeModules } from 'react-native';

type WallpaperManagerType = {
  setWallpaper(uri: string, flag?: number | null): Promise<void>;
  getConstants(): { FLAG_LOCK: number; FLAG_SYSTEM: number };
};

const { WallpaperManager } = NativeModules;

export default WallpaperManager as WallpaperManagerType;
