import React from 'react';
import { Background } from './Background';
import { ImageAndMask } from './ImageAndMask';
import { CTA } from './CTA';
import styles from '../styles/Onboarding.module.scss';

export const Onboarding: React.FC = () => {
  return (
    <div className={styles.onboarding}>
      <Background />
      
      <div className={styles.content}>
        <div className={styles.titles}>
          <h1 className={styles.title1}>Bem-vindo ao</h1>
          <h2 className={styles.title2}>Seu App de Imóveis</h2>
        </div>
        
        <ImageAndMask />
      </div>
      
      <CTA />
    </div>
  );
};

export default Onboarding;