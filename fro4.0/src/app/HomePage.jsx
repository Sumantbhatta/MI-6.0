import React, { useState } from 'react'
import { CiCircleCheck } from "react-icons/ci"
import { FaCartShopping } from "react-icons/fa6"
import { FaUserClock } from "react-icons/fa"
import { MdInventory } from "react-icons/md"
import { SlArrowRight } from "react-icons/sl"
import { motion, AnimatePresence } from 'framer-motion'
import SplashScreen from '@/components/SplashScreen'

// Button Component
function Button({children}) {
    return (
        <motion.a 
            href="/login"
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            initial={{ opacity: 0, y: 20 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ duration: 0.5 }}
        >
            <div className='w-auto h-[35px] gap-1 flex items-center justify-center bg-[#ffbd2b] text-primary font-semibold rounded-xl px-3 py-2 hover:bg-yellow-300 transition-all duration-300'>
                {children}
                <SlArrowRight className='text-primary text-sm font-extrabold' />
            </div>
        </motion.a>
    )
}

// Cards Component
function Cards({children}) {
    return (
        <motion.div 
            className='w-[300px] h-[300px] bg-secondary shadow-sm rounded-xl'
            whileHover={{ scale: 1.05 }}
            initial={{ opacity: 0, y: 50 }}
            whileInView={{ opacity: 1, y: 0 }}
            viewport={{ once: true }}
            transition={{ duration: 0.5 }}
        >
            {children}
        </motion.div>
    )
}

// Navbar Component
// function Navbar() {
//     return (
//         <div className='w-full h-15 flex items-center top-0 left-0 justify-between px-10 bg-primary'>
//             <div className='w-7 h-7 flex gap-5 items-center '>
//                 <img src="/assets/yellowLogo.png" alt="logo" style={{ animationDuration: '4s' }} className='animate-spin'/>
//                 <h1 className='text-[#ffbd2b] font-bold text-3xl'>RealEstatePro</h1>
//             </div>
//             <Button>
//                 <h1>Get Started</h1>
//             </Button>
//         </div>
//     )
// }

function HomePage() {
    const [isLoading, setIsLoading] = useState(true);

    const handleLoadingComplete = () => {
        setIsLoading(false);
    };

    const fadeInUp = {
        initial: { opacity: 0, y: 60 },
        whileInView: { opacity: 1, y: 0 },
        viewport: { once: true },
        transition: { duration: 0.6 }
    };

    const staggerContainer = {
        initial: { opacity: 0 },
        whileInView: { 
            opacity: 1,
            transition: {
                staggerChildren: 0.2
            }
        },
        viewport: { once: true }
    };

    return (
        <>
            <AnimatePresence>
                {isLoading && <SplashScreen onLoadingComplete={handleLoadingComplete} />}
            </AnimatePresence>
            
            <motion.div 
                className="w-full"
                initial={{ opacity: 0 }}
                animate={{ opacity: isLoading ? 0 : 1 }}
                transition={{ duration: 0.8, ease: "easeOut" }}
            >
                {/*<Navbar />*/}

                {/* Hero Section */}
                <div className='w-full h-screen flex items-center justify-center bg-[url("/assets/mainBgg.png")] bg-cover bg-center saturate-0 brightness-50 absolute z-[-1]'> </div>
                <div className='w-full h-screen flex items-center justify-around relative mt-5'>
                    <motion.div 
                        id='left' 
                        className='w-[35%] gap-7 flex flex-col'
                        variants={staggerContainer}
                        initial="initial"
                        whileInView="whileInView"
                        viewport={{ once: true }}
                    >
                        <motion.p 
                            className='text-[#ffbd2b] text-m font-bold'
                            variants={fadeInUp}
                        >WELCOME TO REALESTATEPRO</motion.p>
                        <motion.h1 
                            className='text-white text-7xl' 
                            style={{fontFamily: 'Anton'}}
                            variants={fadeInUp}
                        >YOUR PERFECT COLLABORATOR FOR ANY PROJECT</motion.h1>
                        <motion.p 
                            className='text-white text-sm'
                            variants={fadeInUp}
                        >Streamline your construction projects with our comprehensive management platform. From equipment tracking to project timelines, we've got you covered.</motion.p>
                        <motion.div variants={fadeInUp}>
                            <Button>
                                <h1>Get Started</h1>
                            </Button>
                        </motion.div>
                    </motion.div>

                    <motion.div 
                        className='w-[50%] h-full flex items-center justify-center saturate-100 z-10'
                        initial={{ opacity: 0, scale: 0.8 }}
                        whileInView={{ opacity: 1, scale: 1 }}
                        viewport={{ once: true }}
                        transition={{ duration: 0.8, ease: "easeOut" }}
                    >
                        <img src="/images/chain.png" alt="hero" />
                    </motion.div>

                    <motion.div 
                        className='w-[80%] h-25 bg-[#ffbd2b] absolute bottom-[-90px] rounded-xl flex items-center justify-center'
                        initial={{ y: 50, opacity: 0 }}
                        whileInView={{ y: 0, opacity: 1 }}
                        viewport={{ once: true }}
                        transition={{ duration: 0.8, ease: "easeOut" }}
                    >
                        {/* Company logos */}
                        {[1, 2, 3, 4, 5, 3].map((num, index) => (
                            <motion.img
                                key={index}
                                className='logo'
                                src={`/assets/compLogo/comp${num}.png`}
                                alt="logo"
                                initial={{ opacity: 0, scale: 0.8 }}
                                whileInView={{ opacity: 1, scale: 1 }}
                                viewport={{ once: true }}
                                transition={{ delay: index * 0.1, duration: 0.5 }}
                            />
                        ))}
                    </motion.div>
                </div>

                {/* Second Section */}
                <motion.div 
                    className='w-full h-full flex items-center justify-center mt-[150px] gap-10'
                    variants={staggerContainer}
                    initial="initial"
                    whileInView="whileInView"
                    viewport={{ once: true }}
                >
                    <motion.div 
                        className='w-[400px] h-[400px] flex items-center justify-center bg-[#ffbd2b] rounded-xl relative'
                        variants={fadeInUp}
                    >
                        <img className='rounded-xl absolute top-[-15px] right-[-15px]' src="/assets/images/man_constructionBg.png" alt="" />
                    </motion.div>

                    <motion.div 
                        className='w-[40%] h-full flex flex-col'
                        variants={staggerContainer}
                    >
                        <motion.p variants={fadeInUp} className='text-[#ffbd2b] font-bold mb-5'>WHY CHOOSE US</motion.p>
                        <motion.h1 variants={fadeInUp} className='text-4xl font-bold'>WHAT MAKES <div className='inline-block text-[#ffbd2b]'>US</div> YOUR IDEAL PARTNER</motion.h1>
                        <motion.p variants={fadeInUp}>Our platform combines cutting-edge technology with industry expertise to deliver unmatched project management solutions for construction professionals.</motion.p>

                        <motion.div 
                            className='w-[500px] h-[140px] bg-[#ffbd2b] rounded-xl flex items-center justify-center gap-5 mt-5'
                            variants={fadeInUp}
                        >
                            <CiCircleCheck className='text-primary font-bold text-[100px] pl-5' />
                            <div>
                                <h1 className='text-2xl font-bold'>Extensive Equipment Catalog</h1>
                                <p>Efficiently manage your construction equipment fleet with real-time tracking, maintenance schedules, and utilization analytics.</p>
                            </div>
                        </motion.div>
                    </motion.div>
                </motion.div>

                {/* List Section */}
                <motion.div 
                    className='w-full h-full flex flex-col items-center justify-center mt-[100px] bg-secondary'
                    variants={staggerContainer}
                    initial="initial"
                    whileInView="whileInView"
                    viewport={{ once: true }}
                >
                    <motion.h1 
                        className='text-4xl font-bold p-[40px]'
                        variants={fadeInUp}
                    >MANAGE EVERYTHING</motion.h1>
                    <motion.div 
                        id='imagegrid' 
                        className='grid grid-cols-3 gap-5 pb-24'
                        variants={staggerContainer}
                    >
                        {[2, 3, 4, 5, 6, 'equip'].map((num, index) => (
                            <Cards key={index}>
                                <img 
                                    src={`/assets/equips/${num}.png`} 
                                    className='rounded-xl hover:scale-105 transition-all duration-300' 
                                    alt="" 
                                />
                            </Cards>
                        ))}
                    </motion.div>
                </motion.div>

                {/* Prepared Section */}
                <motion.div 
                    className='w-full h-[300px] bg-black bg-[url("/assets/machines1.png")] bg-cover bg-center bg-no-repeat flex flex-col items-center justify-center relative text-center gap-5'
                    initial={{ opacity: 0 }}
                    whileInView={{ opacity: 1 }}
                    viewport={{ once: true }}
                    transition={{ duration: 0.8 }}
                >
                    <div className='w-[100%] h-[100%] bg-black flex items-center justify-center absolute top-0 left-0 opacity-60'></div>
                    <h1 className='w-[60%] text-white text-4xl font-bold z-10'>GET STARTED WITH <div className='inline-block text-[#ffbd2b]'>REAL ESTATE PRO</div> RIGHT NOW WITHOUT ANY HASSLE</h1>
                    <div className='z-10'>
                        <Button className='z-10'>
                            <h1>Get Started</h1>
                        </Button>
                    </div>
                </motion.div>

                {/* Experience Section */}
                <motion.div 
                    className='w-full min-h-screen bg-white flex items-center justify-center overflow-x-hidden'
                    variants={staggerContainer}
                    initial="initial"
                    whileInView="whileInView"
                    viewport={{ once: true }}
                >
                    <motion.div 
                        className='max-w-7xl w-full flex items-center justify-center gap-10 p-5'
                        variants={staggerContainer}
                    >
                        <motion.div variants={fadeInUp} className='w-[50%]'>
                            <img className='transform' src="/assets/images/trucks.png" alt="JCB"/>
                        </motion.div>
                        <motion.div variants={staggerContainer} className='w-[50%]'>
                            <motion.h1 variants={fadeInUp} className='w-[80%] text-5xl font-bold'>Experience <div className='inline-block text-[#ffbd2b]'>Effeciency</div> & <div className='inline-block text-[#ffbd2b]'>Reliability</div> with Every Project</motion.h1>
                            <motion.p variants={fadeInUp} className='w-[80%] pt-2 text-gray-500'>Experience seamless project execution with our integrated platform. From initial planning to final delivery, we provide the tools and insights you need for success.</motion.p>

                            <motion.div variants={staggerContainer} className='flex pt-6 flex flex-col gap-6'>
                                {[
                                    { icon: <FaCartShopping />, title: "Project Management", description: "Optimize workforce productivity with smart scheduling, time tracking, and performance monitoring tools." },
                                    { icon: <FaUserClock />, title: "User Management", description: "Keep track of materials, equipment, and resources with our advanced inventory management system." },
                                    { icon: <MdInventory />, title: "Inventory Management", description: "Efficiently manage your construction equipment fleet with real-time tracking, maintenance schedules, and utilization analytics." }
                                ].map((item, index) => (
                                    <motion.div 
                                        key={index}
                                        variants={fadeInUp}
                                        className='h-[70px] flex gap-6'
                                    >
                                        <div className='bg-[#ffbd2b] w-[70px] h-[70px] rounded-full text-black flex items-center justify-center text-2xl'>
                                            {item.icon}
                                        </div>
                                        <div>
                                            <h1 className='text-xl font-bold'>{item.title}</h1>
                                            <p className='text-[14px] text-gray-500'>{item.description}</p>
                                        </div>
                                    </motion.div>
                                ))}
                            </motion.div>
                        </motion.div>
                    </motion.div>
                </motion.div>
            </motion.div>
        </>
    )
}

export default HomePage