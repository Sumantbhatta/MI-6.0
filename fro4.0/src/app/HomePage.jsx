import React from 'react'
import { CiCircleCheck } from "react-icons/ci"
import { FaCartShopping } from "react-icons/fa6"
import { FaUserClock } from "react-icons/fa"
import { MdInventory } from "react-icons/md"
import { SlArrowRight } from "react-icons/sl"

// Button Component
function Button({children}) {
    return (
        <a href="/login">
        <div className='w-auto h-[35px] gap-1 flex items-center justify-center bg-[#ffbd2b] text-primary font-semibold rounded-xl px-3 py-2 hover:bg-yellow-300 transition-all duration-300'>
            {children}
            <SlArrowRight className='text-primary text-sm font-extrabold' />
        </div>
        </a>
    )
}

// Cards Component
function Cards({children}) {
    return (
        <div className='w-[300px] h-[300px] bg-secondary shadow-sm rounded-xl'>
            {children}
        </div>
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
    return (
        <div className="w-full">
            {/*<Navbar />*/}

            {/* Hero Section */}
            <div className='w-full h-screen flex items-center justify-center bg-[url("/assets/mainBgg.png")] bg-cover bg-center saturate-0 brightness-50 absolute z-[-1]'> </div>
            <div className='w-full h-screen flex items-center justify-around relative mt-5'>
                <div id='left' className='w-[35%] gap-7 flex flex-col'>
                    <p className='text-[#ffbd2b] text-m font-bold'>WELCOME TO REALESTATEPRO</p>
                    <h1 className='text-white text-7xl' style={{fontFamily: 'Anton'}}>YOUR PERFECT COLLABORATOR FOR ANY PROJECT</h1>
                    <p className='text-white text-sm'>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Dolorem accusantium ipsum et vero ipsa beatae eius laboriosam molestiae sequi necessitatibus?</p>
                    <Button>
                        <h1>Get Started</h1>
                    </Button>
                </div>

                <div className='w-[50%] h-full flex items-center justify-center saturate-100 z-10'>
                    <img src="/images/chain.png" alt="hero" />
                </div>

                <div className='w-[80%] h-25 bg-[#ffbd2b] absolute bottom-[-90px] rounded-xl flex items-center justify-center'>
                    <img className='logo' src="/assets/compLogo/comp1.png" alt="logo" />
                    <img className='logo' src="/assets/compLogo/comp2.png" alt="logo" />
                    <img className='logo' src="/assets/compLogo/comp3.png" alt="logo" />
                    <img className='logo' src="/assets/compLogo/comp4.png" alt="logo" />
                    <img className='logo' src="/assets/compLogo/comp5.png" alt="logo" />
                    <img className='logo' src="/assets/compLogo/comp3.png" alt="logo" />
                </div>
            </div>

            {/* Second Section */}
            <div className='w-full h-full flex items-center justify-center mt-[150px] gap-10'>
                <div className='w-[400px] h-[400px] flex items-center justify-center bg-[#ffbd2b] rounded-xl relative'>
                    <img className='rounded-xl absolute top-[-15px] right-[-15px]' src="/assets/images/man_constructionBg.png" alt="" />
                </div>

                <div className='w-[40%] h-full flex flex-col'>
                    <p className='text-[#ffbd2b] font-bold mb-5'>WHY CHOOSE US</p>
                    <h1 className='text-4xl font-bold'>WHAT MAKES <div className='inline-block text-[#ffbd2b]'>US</div> YOUR IDEAL PARTNER</h1>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium enim nam earum eaque ratione eius, amet blanditiis tempora quibusdam eligendi.</p>

                    <div className='w-[500px] h-[140px] bg-[#ffbd2b] rounded-xl flex items-center justify-center gap-5 mt-5'>
                        <CiCircleCheck className='text-primary font-bold text-[100px] pl-5' />
                        <div>
                            <h1 className='text-2xl font-bold'>Extensive Equipment Catalog</h1>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium enim nam earum eaque ratione eius, amet blanditiis tempora quibusdam eligendi.</p>
                        </div>
                    </div>
                </div>
            </div>

            {/* List Section */}
            <div className='w-full h-full flex flex-col items-center justify-center mt-[100px] bg-secondary'>
                <h1 className='text-4xl font-bold p-[40px]'>MANAGE EVERYTHING</h1>
                <div id='imagegrid' className='grid grid-cols-3 gap-5 pb-24'>
                    <Cards><img src="/assets/equips/2.png" className='rounded-xl hover:scale-105 transition-all duration-300' alt="" /></Cards>
                    <Cards><img src="/assets/equips/3.png" className='rounded-xl hover:scale-105 transition-all duration-300' alt="" /></Cards>
                    <Cards><img src="/assets/equips/4.png" className='rounded-xl hover:scale-105 transition-all duration-300' alt="" /></Cards>
                    <Cards><img src="/assets/equips/5.png" className='rounded-xl hover:scale-105 transition-all duration-300' alt="" /></Cards>
                    <Cards><img src="/assets/equips/6.png" className='rounded-xl hover:scale-105 transition-all duration-300' alt="" /></Cards>
                    <Cards><img src="/assets/equips/equip.png" className='rounded-xl hover:scale-105 transition-all duration-300' alt="" /></Cards>
                </div>
            </div>

            {/* Prepared Section */}
            <div className='w-full h-[300px] bg-black bg-[url("/assets/machines1.png")] bg-cover bg-center bg-no-repeat flex flex-col items-center justify-center relative text-center gap-5'>
                <div className='w-[100%] h-[100%] bg-black flex items-center justify-center absolute top-0 left-0 opacity-60'></div>
                <h1 className='w-[60%] text-white text-4xl font-bold z-10'>GET STARTED WITH <div className='inline-block text-[#ffbd2b]'>REAL ESTATE PRO</div> RIGHT NOW WITHOUT ANY HASSLE</h1>
                <div className='z-10'>
                    <Button className='z-10'>
                        <h1>Get Started</h1>
                    </Button>
                </div>
            </div>

            {/* Experience Section */}
            <div className='w-full min-h-screen bg-white flex items-center justify-center overflow-x-hidden'>
                <div className='max-w-7xl w-full flex items-center justify-center gap-10 p-5'>
                    <div className='w-[50%]'>
                        <img className='transform' src="/assets/images/trucks.png" alt="JCB"/>
                    </div>
                    <div className='w-[50%]'>
                        <h1 className='w-[80%] text-5xl font-bold'>Experience <div className='inline-block text-[#ffbd2b]'>Effeciency</div> & <div className='inline-block text-[#ffbd2b]'>Reliability</div> with Every Project</h1>
                        <p className='w-[80%] pt-2 text-gray-500'>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Placeat obcaecati neque voluptatum officia porro totam nihil ducimus, ipsam perferendis adipisci!</p>

                        <div className='flex pt-6 flex flex-col gap-6'>
                            <div className='h-[70px] flex gap-6'>
                                <div className='bg-[#ffbd2b] w-[70px] h-[70px] rounded-full text-black flex items-center justify-center text-2xl'>
                                    <FaCartShopping />
                                </div>
                                <div>
                                    <h1 className='text-xl font-bold'>Project Management</h1>
                                    <p className='text-[14px] text-gray-500'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae?</p>
                                </div>
                            </div>

                            <div className='h-[70px] flex gap-6'>
                                <div className='bg-[#ffbd2b] w-[70px] h-[70px] rounded-full text-black flex items-center justify-center text-2xl'>
                                    <FaUserClock />
                                </div>
                                <div>
                                    <h1 className='text-xl font-bold'>User Management</h1>
                                    <p className='text-[14px] text-gray-500'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae?</p>
                                </div>
                            </div>

                            <div className='h-[70px] flex gap-6'>
                                <div className='bg-[#ffbd2b] w-[70px] h-[70px] rounded-full text-black flex items-center justify-center text-2xl'>
                                    <MdInventory />
                                </div>
                                <div>
                                    <h1 className='text-xl font-bold'>Inventory Management</h1>
                                    <p className='text-[14px] text-gray-500'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem, beatae?</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default HomePage