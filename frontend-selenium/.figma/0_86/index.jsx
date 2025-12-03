import React from 'react';

import styles from './index.module.scss';

const Component = () => {
  return (
    <div className={styles.iPhoneXStatusBarsSta}>
      <div className={styles.timeStyle}>
        <p className={styles.aTime3}>
          <span className={styles.aTime}>9:4</span>
          <span className={styles.aTime2}>1</span>
        </p>
      </div>
      <img
        src="../image/mha1j6o8-oog2ek5.svg"
        className={styles.cellularConnection}
      />
      <img src="../image/mha1j6o8-n73ciqb.svg" className={styles.wifi} />
      <img src="../image/mha1j6o7-qq9u3lq.svg" className={styles.battery} />
    </div>
  );
}

export default Component;
