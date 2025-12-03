import React from 'react';
import styles from '../styles/CTA.module.scss';

interface CTAProps {
  className?: string;
}

export const CTA: React.FC<CTAProps> = ({ className = '' }) => {
  return (
    <div className={`${styles.cta} ${className}`}>
      <h2 className={styles.title}>
        <span className={styles.titlePart1}>Encontre o lugar</span>
        <span className={styles.titlePart2}>dos seus sonhos!</span>
      </h2>
      
      <button className={styles.signUpButton}>
        <span className={styles.signUpText}>Registrar</span>
      </button>
      
      <div className={styles.loginText}>
        <span className={styles.loginQuestion}>Já tem uma conta? </span>
        <span className={styles.loginLink}>Entrar</span>
      </div>
    </div>
  );
};

export default CTA;