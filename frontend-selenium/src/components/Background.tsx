import React from 'react';
import styles from '../styles/Background.module.scss';

interface BackgroundProps {
  className?: string;
}

export const Background: React.FC<BackgroundProps> = ({ className = '' }) => {
  return (
    <div className={`${styles.background} ${className}`}>
      <div className={styles.rectangle1}></div>
      <div className={styles.rectangle2}></div>
      <div className={styles.ellipse1}></div>
      <div className={styles.ellipse2}></div>
      <div className={styles.ellipse3}></div>
      <div className={styles.ellipse4}></div>
    </div>
  );
};

export default Background;