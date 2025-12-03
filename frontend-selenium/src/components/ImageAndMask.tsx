import React from 'react';
import styles from '../styles/ImageAndMask.module.scss';

interface ImageAndMaskProps {
  className?: string;
}

export const ImageAndMask: React.FC<ImageAndMaskProps> = ({ className = '' }) => {
  return (
    <div className={`${styles.imageAndMask} ${className}`}>
      <img 
        src="/assets/main-image.png" 
        alt="Imagem Principal" 
        className={styles.mainImage}
      />
      <img 
        src="/assets/mask-group.png" 
        alt="Máscara" 
        className={styles.maskGroup}
      />
    </div>
  );
};

export default ImageAndMask;